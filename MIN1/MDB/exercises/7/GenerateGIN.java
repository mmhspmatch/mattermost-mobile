import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.StringTokenizer;

import static org.apache.hadoop.mapreduce.Job.getInstance;

public class GenerateGIN {

    public static class GINMapper extends Mapper<Object, Text, Text, IntSetWritable> {

        private String preprocess (String str) {
            return str.toLowerCase().replaceAll("[^a-z]", "").strip();
        }

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String fileName = ((FileSplit) context.getInputSplit()).getPath().getName();
            StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()) {
                String word = preprocess(itr.nextToken());
                if (!word.isEmpty()) {
                    Text t = new Text(word);
                    IntSetWritable isw = new IntSetWritable(Integer.parseInt(fileName));
                    context.write(t, isw);
                }
            }
        }

    }

    public static class GINReducer extends Reducer<Text, IntSetWritable, Text, IntSetWritable> {

        public void reduce(Text key, Iterable<IntSetWritable> values, Context context)
                    throws IOException, InterruptedException {
            IntSetWritable isw = new IntSetWritable();
            for (IntSetWritable val : values) {
                isw.add(val);
            }
            context.write(key, isw);
        }

    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = getInstance(conf, "generate gin index");
        job.setJarByClass(GenerateGIN.class);
        job.setMapperClass(GINMapper.class);
        job.setCombinerClass(GINReducer.class);
        job.setReducerClass(GINReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntSetWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}

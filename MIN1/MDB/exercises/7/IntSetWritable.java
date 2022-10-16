import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class IntSetWritable implements Writable {
    protected Set<Integer> s = new TreeSet();

    public IntSetWritable() {
    }

    public IntSetWritable(Integer i) {
        s.add(i);
    }

    public void add (Integer i) {
        s.add(i);
    }

    public void add (IntSetWritable isw) {
        s.addAll(isw.s);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer i : s) {
            sb.append(i).append(" ");
        }

        return s.toString().trim();
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        s.clear();
        IntWritable sz = new IntWritable();
        sz.readFields(in);
        int len = sz.get();
        for (int i = 0; i < len; i++) {
            IntWritable val = new IntWritable();
            val.readFields(in);
            s.add(val.get());
        }
    }

    @Override
    public void write(DataOutput out) throws IOException {
        IntWritable sz = new IntWritable(s.size());
        sz.write(out);
        for (Integer i : s) {
            IntWritable iw = new IntWritable(i);
            iw.write(out);
        }
    }
}

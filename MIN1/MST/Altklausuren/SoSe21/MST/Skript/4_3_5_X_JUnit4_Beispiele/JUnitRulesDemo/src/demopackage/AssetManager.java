package demopackage;

import java.io.File;
import java.io.IOException;

public class AssetManager {
	
	int numberofAssets=0;
	
	public void createAssets(File assets, int numberOfAssets) throws IOException {
	    for (int index = 0; index < numberOfAssets; index++) {
	      File asset = new File(assets, String.format("asset-%d.mpg", index));
	      numberofAssets++;
	    }
	  }
	
	public int countAssets(){
		return numberofAssets;
	}
}

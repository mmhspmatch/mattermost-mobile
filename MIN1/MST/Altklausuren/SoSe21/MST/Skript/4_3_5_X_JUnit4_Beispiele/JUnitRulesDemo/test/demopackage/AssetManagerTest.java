package demopackage;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class AssetManagerTest {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	@Rule
	public MyRule myRule = new MyRule();
	
	@Rule
	public SecondRule secondRule= new SecondRule();

	@Test
	public void countsAssets() throws IOException {
		System.out.println("in der Testmethode am Anfang");
		AssetManager am = new AssetManager();
		File assets = tempFolder.newFolder("assets");
		am.createAssets(assets, 3);
		assertEquals(3, am.countAssets());
		System.out.println("in der Testmethode am Ende");
	}
}

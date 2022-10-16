package demopackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestRule;

public class RuleChainDemo {
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	@Rule
    public final TestRule chain = RuleChain
                           .outerRule(new MyRule())
                           .around(new SecondRule());

	@Test
	public void countsAssets() throws IOException {
		System.out.println("am Anfang der Testmethode");
		AssetManager am = new AssetManager();
		File assets = tempFolder.newFolder("assets");
		am.createAssets(assets, 3);
		assertEquals(3, am.countAssets());
		System.out.println("am Ende der Testmethode");
	}

}

package demopackage;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class FooTest {
	
	@Rule
	public TestRule setLogLevelToDebug= new TestRule(){
		@Override
		public Statement apply(final Statement base, Description desc){
			return new Statement(){
				@Override
				public void evaluate() throws Throwable{
					//nix	
				}
			};
		}
	};

}

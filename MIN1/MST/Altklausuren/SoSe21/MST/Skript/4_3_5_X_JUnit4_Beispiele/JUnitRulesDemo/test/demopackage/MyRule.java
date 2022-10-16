package demopackage;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyRule implements TestRule {

	@Override
	public Statement apply(Statement base, Description description) {
		return new Statement(){
			@Override
			public void evaluate() throws Throwable{
				System.out.println("in MyRule, vorher");
				base.evaluate();
				System.out.println("in MyRule, nachher");
			}
		};
	}

}

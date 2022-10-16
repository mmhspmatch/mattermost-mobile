package demopackage;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class SecondRule implements TestRule {

	@Override
	public Statement apply(Statement base, Description desc) {
		Statement myStatement = new MyStatement(base);
		
		return myStatement;
	}

}

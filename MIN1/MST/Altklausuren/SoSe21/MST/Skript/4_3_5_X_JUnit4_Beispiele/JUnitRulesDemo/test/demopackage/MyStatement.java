package demopackage;

import org.junit.runners.model.Statement;

public class MyStatement extends Statement {
	
	Statement base;
	
	public MyStatement(Statement base){
		this.base = base;
	}

	@Override
	public void evaluate() throws Throwable {
		System.out.println("im MyStatement vorher");
		base.evaluate();
		System.out.println("im MyStatement nachher");
	}
}

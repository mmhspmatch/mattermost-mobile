package demopackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SecondTest {

	private final SecondClassUnderTest greeter = new SecondClassUnderTest();
	
	@Test
	void addition() {
		assertEquals("Hello Sepp", greeter.greeting("Sepp")) ;
	}

}

package demopackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TagDemoTest {

	@Test
	@Tag("Tagdemo")
	void testCompute_1() {
		assertEquals(1, Fibonacci.compute(1));
	}
	
	@Test
	@Tag("Tagdemo")
	void testCompute_2() {
		assertEquals(1, Fibonacci.compute(2));
	}
	
	@Test
	@Tag("Tagdemo")
	void testCompute_3() {
		assertEquals(3, Fibonacci.compute(4));
	}

}

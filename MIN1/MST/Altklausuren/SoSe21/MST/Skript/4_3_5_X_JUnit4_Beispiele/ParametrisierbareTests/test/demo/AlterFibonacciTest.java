package demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlterFibonacciTest {

	@Test
	public void testCompute() {
		assertEquals(0, Fibonacci.compute(0));
		assertEquals(1, Fibonacci.compute(1));
		assertEquals(1, Fibonacci.compute(2));
		assertEquals(2, Fibonacci.compute(3));
		assertEquals(3, Fibonacci.compute(4));
		assertEquals(5, Fibonacci.compute(5));
		assertEquals(8, Fibonacci.compute(6));
	}
}

package demo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciTest_ParametrisiertMitKonstruktor {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 },
				{ 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
	}

	public int fInput;

	public int fExpected;

	
	public FibonacciTest_ParametrisiertMitKonstruktor(int input, int expected) {
		fInput = input;
		fExpected = expected;
	}
	

	@Test
	public void test() {
		System.out.println("test mit "+ fInput + " , "+ fExpected);
		assertEquals(fExpected, Fibonacci.compute(fInput));
	}
	
	
}

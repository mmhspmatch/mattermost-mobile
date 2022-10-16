package demopackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FibonacciTest {

	@Test
	void testCompute() {
		assertEquals(0, Fibonacci.compute(0));
		assertEquals(1, Fibonacci.compute(1));
		assertEquals(1, Fibonacci.compute(2));
		assertEquals(2, Fibonacci.compute(3));
		assertEquals(3, Fibonacci.compute(4));
		assertEquals(5, Fibonacci.compute(5));
		assertEquals(8, Fibonacci.compute(6));
	}
	
	@ParameterizedTest
	@CsvSource({
	    "0,0",
	    "1,1",
	    "1,2",
	    "2,3",
	    "3,4",
	    "5,5",
	    "8,6"
	})
	void testWithCsvSource(int result, int input) {
		System.out.println("Test mit "+ result + " , "+ input);
	    assertEquals(result, Fibonacci
	    		.compute(input));
	 
	}

}

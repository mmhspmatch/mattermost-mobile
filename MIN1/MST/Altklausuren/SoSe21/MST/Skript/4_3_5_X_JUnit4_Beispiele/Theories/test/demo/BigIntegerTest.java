package demo;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assume.*;

@RunWith(Theories.class)
public class BigIntegerTest {

	@Theory
	public void multiply_follows_commutative(BigInteger i1, BigInteger i2) {
		System.out.println("Test multiply_follows_commutative() mit");
		System.out.println(i1 +" und "+i2);
		assertEquals(i1.multiply(i2), i2.multiply(i1));
	}
	
	@Theory
	public void divide_is_inverse_of_multiply(BigInteger i1, BigInteger i2) {
		System.out.println("Test divide_is_inverse_of_multiply() mit");
		System.out.println(i1 +" und "+i2);
		assumeThat(i2.toString(), is(not("0")));
		assertEquals(i1.multiply(i2).divide(i2), i1);
	}
	
	@Theory
	public void multiply_behaves_like_primitive(int firstInt, int secondInt){
		System.out.println("Test multiply_behaves_like_primitive() mit");
		System.out.println(firstInt +" und "+secondInt);
		assertEquals(new BigInteger(String.valueOf(firstInt*secondInt)), 
				new BigInteger(String.valueOf(firstInt)).multiply(new BigInteger(String.valueOf(secondInt))));
	}
	
	@Theory
	public void multiply_with_mixed_datatypes(int firstInt, BigInteger i2){
		System.out.println("Test multiply_with_mixed_datatypes() mit");
		System.out.println(firstInt +" und "+i2);
		assertEquals(new BigInteger(String.valueOf(firstInt)).multiply(i2), 
				i2.multiply(new BigInteger(String.valueOf(firstInt))));
	}
	
	
	@DataPoints
	public static BigInteger[] TEST_DATA = new BigInteger[]{
		new BigInteger("-1"),
		new BigInteger("0"),
		new BigInteger("42"),
		new BigInteger("12121234343434231213"),
	};
	
	@DataPoints
	public static int[] INT_DATA = {1,2,3,4,5,6,7,8,9};

}

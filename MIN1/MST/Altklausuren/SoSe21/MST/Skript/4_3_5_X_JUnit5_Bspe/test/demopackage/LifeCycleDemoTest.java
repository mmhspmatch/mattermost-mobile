package demopackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LifeCycleDemoTest {
	
	private static Calculator calculator;
	
	@BeforeAll
	public static void switchOnCalculator() {
		System.out.println("\tSwitch on calculator");
		calculator = new Calculator();
		calculator.switchOn();
	}
     
    @BeforeEach
    public void clearCalculator() {
		System.out.println("zu Beginn jeden Tests wird der Calculator zurueckgesetzt");
		calculator.clear();
	}
     
    @Test
	public void test_add() {
    	System.out.println("test_add()");
		calculator.add(1); 
		calculator.add(1); 
		assertEquals(calculator.getResult(), 2); 
	}
 
	@Test
	public void test_subtract() {
		System.out.println("test_subtract()");
		calculator.add(10); 
		calculator.subtract(2); 
		assertEquals(8,calculator.getResult()); 
	}
 
	@Test
	public void test_divide() {
		System.out.println("test_divide()");
		calculator.add(8); 
		calculator.divide(2); 
		assertEquals(calculator.getResult(), 4); 
	}
 
	@Disabled("not ready yet")
	@Test
	public void test_multiply() {
		System.out.println("test_multiply()");
		calculator.add(10); 
		calculator.multiply(10); 
		assertEquals(calculator.getResult(), 100); 
	}
     
    @AfterEach
    void tearThis(){
        System.out.println("@AfterEach executed");
    }
     
    @AfterAll
    public static void switchOffCalculator() {
		System.out.println("\tSwitch off calculator");
		calculator.switchOff();
		calculator = null;
	}

}

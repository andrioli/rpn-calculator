package br.com.ooboo.calculator.operator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DivideTest {
	
	private Divide op;

	@Before
	public void init() {
		op = new Divide();
	}
	
	@Test
	public void ShouldDivideCorrectly() {
		BigDecimal result = op.executeImplementation(
				new BigDecimal(12), new BigDecimal(2));
		
		assertEquals(new BigDecimal(6), result);
	}
	
	@Test(expected=ArithmeticException.class)
	public void ShouldThrowExceptionWhendDivideByZero() {
		op.executeImplementation(new BigDecimal(12), new BigDecimal(0));
	}
}

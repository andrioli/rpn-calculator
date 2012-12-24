package br.com.ooboo.calculator.operator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class SubtractTest {

	@Test
	public void ShouldSubtractCorrectly() {
		Subtract op = new Subtract();
		
		BigDecimal result = op.executeImplementation(
				new BigDecimal(3), new BigDecimal(4));
		
		assertEquals(new BigDecimal(-1), result);
	}
	
}

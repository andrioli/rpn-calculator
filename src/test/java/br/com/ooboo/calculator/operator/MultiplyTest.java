package br.com.ooboo.calculator.operator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class MultiplyTest {

	@Test
	public void ShouldMultiplyCorrectly() {
		Multiply op = new Multiply();
		
		BigDecimal result = op.executeImplementation(
				new BigDecimal(12), new BigDecimal(2));
		
		assertEquals(new BigDecimal(24), result);
	}
	
}

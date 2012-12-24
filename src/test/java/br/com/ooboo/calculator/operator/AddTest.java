package br.com.ooboo.calculator.operator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class AddTest {

	@Test
	public void ShouldAddCorrectly() {
		Add op = new Add();
		
		BigDecimal result = op.executeImplementation(
				new BigDecimal(3), new BigDecimal(4));
		
		assertEquals(new BigDecimal(7), result);
	}
	
}

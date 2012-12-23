package br.com.ooboo.calculator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class RpnCalculatorTest {
	
	@Test
	public void NewCalculatorHas0InItsAccumulator() {
		RpnCalculator calculator = new RpnCalculator();
		Assert.assertEquals(BigDecimal.ZERO, calculator.getAccumulator());
	}
	
}

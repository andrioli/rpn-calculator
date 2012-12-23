package br.com.ooboo.calculator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ANewlyCreateRpnCalculatorShould {

	private RpnCalculator calculator;

	@Before
	public void init() {
		calculator = new RpnCalculator();
	}
	
	@Test
	public void Have0InItsAccumulator() {
		Assert.assertEquals(BigDecimal.ZERO, calculator.getAccumulator());
	}
	
	@Test
	public void AllowItsAccumulatorToBeSet() {
		BigDecimal value = new BigDecimal(42);
		calculator.setAccumulator(value);
		Assert.assertEquals(value, calculator.getAccumulator());
	}

}

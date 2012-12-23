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
	
	@Test
	public void AllowMultipleValuesToBeStored() {
		BigDecimal value1 = new BigDecimal(42);
		BigDecimal value2 = new BigDecimal(2);
		BigDecimal value3 = new BigDecimal(3);
		calculator.setAccumulator(value1);
		calculator.enter();
		calculator.setAccumulator(value2);
		calculator.enter();
		calculator.setAccumulator(value3);
		Assert.assertEquals(value3, calculator.getAccumulator());
		calculator.drop();
		Assert.assertEquals(value2, calculator.getAccumulator());
		calculator.drop();
		Assert.assertEquals(value1, calculator.getAccumulator());
		calculator.drop();
		Assert.assertEquals(BigDecimal.ZERO, calculator.getAccumulator());
	}

}

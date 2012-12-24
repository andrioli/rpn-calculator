package br.com.ooboo.calculator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class RpnCalculatorFactorialTest {

	private RpnCalculator calculator;

	@Before
	public void init() {
		calculator = new RpnCalculator();
	}
	
	@Test
	public void FactorialOf_0_Is_1() {
		calculator.execute("!");
		assertEquals(BigDecimal.ONE, calculator.getAccumulator());
	}

	@Test
	public void FactorialOf_5_Is_120() {
		calculator.setAccumulator(new BigDecimal(5));
		calculator.execute("!");
		assertEquals(new BigDecimal(120), calculator.getAccumulator());
	}
	
}

package br.com.ooboo.calculator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class AnRpnCalculatorWithTwoOperandsShould {

	private RpnCalculator calculator;

	@Before
	public void init() {
		calculator = new RpnCalculator();
		calculator.setAccumulator(new BigDecimal(3));
		calculator.enter();
		calculator.setAccumulator(new BigDecimal(4));
	}
	
	@Test
	public void AddTwoNumbersCorrectly() {
		calculator.add();
		assertEquals(new BigDecimal(7), calculator.getAccumulator());
	}
	
	@Test
	public void SubtractTwoNumbersCorrectly() {
		calculator.subtract();
		assertEquals(new BigDecimal(-1), calculator.getAccumulator());
	}
	
}

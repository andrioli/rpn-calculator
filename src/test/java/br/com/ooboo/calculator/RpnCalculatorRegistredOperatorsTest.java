package br.com.ooboo.calculator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.ooboo.calculator.operator.NoSuchOperatorException;

public class RpnCalculatorRegistredOperatorsTest {
	
	private RpnCalculator calculator;
	
	BigDecimal value1 = new BigDecimal(42);
	BigDecimal value2 = new BigDecimal(4);
	
	@Before
	public void init() {
		calculator = new RpnCalculator();
		calculator.setAccumulator(value1);
		calculator.enter();
		calculator.setAccumulator(value2);
	}

	@Test
	public void ShouldBeAbleToAdd() {
		calculator.execute("+");
		assertEquals(new BigDecimal(46), calculator.getAccumulator());
	}
	
	@Test
	public void ShouldBeAbleToSubtract() {
		calculator.execute("-");
		assertEquals(new BigDecimal(38), calculator.getAccumulator());
	}
	
	@Test
	public void ShouldBeAbleToComputeFactorial() {
		calculator.execute("!");
		assertEquals(new BigDecimal(24), calculator.getAccumulator());
	}
	
	@Test
	public void ShouldBeAbleToMultiply() {
		calculator.execute("*");
		assertEquals(new BigDecimal(168), calculator.getAccumulator());
	}
	
	@Test(expected = NoSuchOperatorException.class)
	public void ShouldThrowExceptionForUnknownOperator() {
		calculator.execute("bogus ___ operator");
	}
}

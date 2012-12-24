package br.com.ooboo.calculator;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.ooboo.calculator.operator.NoSuchOperatorException;

public class RpnCalculatorRegistredOperatorsTest {
	
	private RpnCalculator calculator;
	
	@Before
	public void init() {
		calculator = new RpnCalculator();
	}

	@Test
	public void ShouldBeAbleToExecuteAdd() {
		calculator.execute("+");
	}
	
	@Test
	public void ShouldBeAbleToExecuteSubtract() {
		calculator.execute("-");
	}
	
	@Test
	public void ShouldBeAbleToExecuteFactorial() {
		calculator.execute("!");
	}
	
	@Test
	public void ShouldBeAbleToExecuteMultiply() {
		calculator.execute("*");
	}
	
	@Test
	public void ShouldBeAbleToExecuteDivide() {
		calculator.setAccumulator(BigDecimal.ONE);
		calculator.execute("/");
	}
	
	@Test(expected = NoSuchOperatorException.class)
	public void ShouldThrowExceptionForUnknownOperator() {
		calculator.execute("bogus ___ operator");
	}
}

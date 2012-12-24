package br.com.ooboo.calculator;

import org.junit.Before;
import org.junit.Test;

import br.com.ooboo.calculator.operator.NoSuchOperatorException;

public class MathOperatorFactoryRegistredOperatorsTest {
	
	private MathOperatorFactory factory;
	
	@Before
	public void init() {
		factory = new MathOperatorFactory();
	}

	@Test
	public void ShouldBeAbleToFindAdd() {
		factory.findOperatorNamed("+");
	}
	
	@Test
	public void ShouldBeAbleToFindSubtract() {
		factory.findOperatorNamed("-");
	}
	
	@Test
	public void ShouldBeAbleToFindFactorial() {
		factory.findOperatorNamed("!");
	}
	
	@Test
	public void ShouldBeAbleToFindMultiply() {
		factory.findOperatorNamed("*");
	}
	
	@Test
	public void ShouldBeAbleToFindDivide() {
		factory.findOperatorNamed("/");
	}
	
	@Test(expected = NoSuchOperatorException.class)
	public void ShouldThrowExceptionForUnknownOperator() {
		factory.findOperatorNamed("bogus ___ operator");
	}
	
}

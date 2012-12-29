package br.com.ooboo.calculator.operator;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MathOperatorFactoryRegistredOperatorsTest {

	private MathOperatorFactory factory;

	@Before
	public void init() {
		factory = new ShortNamedMathOperatorFactory();
	}

	@Test
	public void ShouldBeAbleToFindAdd() {
		MathOperator op = factory.findOperatorNamed("+");
		assertThat(op, instanceOf(Add.class));
	}

	@Test
	public void ShouldBeAbleToFindSubtract() {
		MathOperator op = factory.findOperatorNamed("-");
		assertThat(op, instanceOf(Subtract.class));
	}

	@Test
	public void ShouldBeAbleToFindFactorial() {
		MathOperator op = factory.findOperatorNamed("!");
		assertThat(op, instanceOf(Factorial.class));
	}

	@Test
	public void ShouldBeAbleToFindMultiply() {
		MathOperator op = factory.findOperatorNamed("*");
		assertThat(op, instanceOf(Multiply.class));
	}

	@Test
	public void ShouldBeAbleToFindDivide() {
		MathOperator op = factory.findOperatorNamed("/");
		assertThat(op, instanceOf(Divide.class));
	}
	
	@Test
	public void ShouldBeAbleToFindSum() {
		MathOperator op = factory.findOperatorNamed("sum");
		assertThat(op, instanceOf(Sum.class));
	}
	
	@Test
	public void ShouldBeAbleToFindPrimeFactors() {
		MathOperator op = factory.findOperatorNamed("primeFactors");
		assertThat(op, instanceOf(PrimeFactors.class));
	}

	@Test(expected = NoSuchOperatorException.class)
	public void ShouldThrowExceptionForUnknownOperator() {
		factory.findOperatorNamed("bogus ___ operator");
	}

}

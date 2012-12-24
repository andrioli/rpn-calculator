package br.com.ooboo.calculator.operator;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.ooboo.calculator.operator.Add;
import br.com.ooboo.calculator.operator.Divide;
import br.com.ooboo.calculator.operator.Factorial;
import br.com.ooboo.calculator.operator.MathOperator;
import br.com.ooboo.calculator.operator.MathOperatorFactory;
import br.com.ooboo.calculator.operator.Multiply;
import br.com.ooboo.calculator.operator.NoSuchOperatorException;
import br.com.ooboo.calculator.operator.ShortNamedMathOperatorFactory;
import br.com.ooboo.calculator.operator.Subtract;

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

	@Test(expected = NoSuchOperatorException.class)
	public void ShouldThrowExceptionForUnknownOperator() {
		factory.findOperatorNamed("bogus ___ operator");
	}

}

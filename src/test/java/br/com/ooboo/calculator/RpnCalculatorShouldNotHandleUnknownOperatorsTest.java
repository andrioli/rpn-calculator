package br.com.ooboo.calculator;

import org.junit.Test;

import br.com.ooboo.calculator.RpnCalculator;
import br.com.ooboo.calculator.operator.MathOperator;
import br.com.ooboo.calculator.operator.MathOperatorFactory;
import br.com.ooboo.calculator.operator.NoSuchOperatorException;

public class RpnCalculatorShouldNotHandleUnknownOperatorsTest {

	private static class AlwaysFailingFactory implements MathOperatorFactory {

		@Override
		public MathOperator findOperatorNamed(String operatorName) {
			throw new NoSuchOperatorException();
		}

	}
	
	@Test(expected=NoSuchOperatorException.class)
	public void foo() {
		RpnCalculator calculator = new RpnCalculator(new AlwaysFailingFactory());
		calculator.execute("+");
	}
}

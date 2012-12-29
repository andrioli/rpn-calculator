package br.com.ooboo.calculator;

import org.junit.Test;

import br.com.ooboo.calculator.operator.MathOperator;
import br.com.ooboo.calculator.operator.MathOperatorFactory;
import br.com.ooboo.calculator.operator.NoSuchOperatorException;

public class RpnCalculatorShould {

	private static class AlwaysFailingFactory implements MathOperatorFactory {

		@Override
		public MathOperator findOperatorNamed(String operatorName) {
			throw new NoSuchOperatorException();
		}

	}
	
	private static class FakeMathOperatorFactory implements MathOperatorFactory {

		@Override
		public MathOperator findOperatorNamed(String operatorName) {
			return new MathOperator() {
				@Override
				public void execute(OperandStack values) {
					// Do nothing
				}
			};
		}
		
	}
	
	@Test(expected=NoSuchOperatorException.class)
	public void NotHandleUnknownOperators() {
		RpnCalculator calculator = new RpnCalculator(new AlwaysFailingFactory());
		calculator.execute("+");
	}
	
	@Test
	public void HandleKnownOperators() {
		RpnCalculator calculator = new RpnCalculator(new FakeMathOperatorFactory());
		calculator.execute("+");
	}
	
}

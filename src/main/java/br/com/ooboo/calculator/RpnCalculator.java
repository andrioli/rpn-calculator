package br.com.ooboo.calculator;

import java.math.BigDecimal;

import br.com.ooboo.calculator.operator.MathOperator;
import br.com.ooboo.calculator.operator.MathOperatorFactory;
import br.com.ooboo.calculator.operator.ShortNamedMathOperatorFactory;

public class RpnCalculator {
	
	private OperandStack values = new OperandStack();
	
	private MathOperatorFactory factory;
	
	public RpnCalculator() {
		this(new ShortNamedMathOperatorFactory());
	}
	
	public RpnCalculator(MathOperatorFactory factory) {
		this.factory = factory;
	}

	public BigDecimal getAccumulator() {
		return values.peek();
	}

	public void setAccumulator(BigDecimal value) {
		values.replaceTop(value);
	}

	public void enter() {
		values.push(getAccumulator());
	}

	public void drop() {
		values.pop();
	}

	public void execute(String operatorName) {
		MathOperator op = findOperatorNamed(operatorName);
		op.execute(values);
	}

	private MathOperator findOperatorNamed(String operatorName) {
		return factory.findOperatorNamed(operatorName);
	}
	
}

package br.com.ooboo.calculator;

import java.math.BigDecimal;

import br.com.ooboo.calculator.operator.MathOperator;

public class RpnCalculator {
	
	private OperandStack values = new OperandStack();

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
		return new MathOperatorFactory().findOperatorNamed(operatorName);
	}
	
}

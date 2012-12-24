package br.com.ooboo.calculator;

import java.math.BigDecimal;

import br.com.ooboo.calculator.operator.Add;
import br.com.ooboo.calculator.operator.Divide;
import br.com.ooboo.calculator.operator.Factorial;
import br.com.ooboo.calculator.operator.MathOperator;
import br.com.ooboo.calculator.operator.Multiply;
import br.com.ooboo.calculator.operator.NoSuchOperatorException;
import br.com.ooboo.calculator.operator.Subtract;

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
		MathOperator op = null;
		
		if ("+".equals(operatorName)) {
			op = new Add();
		} else if ("-".equals(operatorName)) {
			op = new Subtract();
		} else if ("!".equals(operatorName)) {
			op = new Factorial();
		} else if ("*".equals(operatorName)) {
			op = new Multiply();
		} else if ("/".equals(operatorName)) {
			op = new Divide();
		} else {
			throw new NoSuchOperatorException(
					"Invalid operator named: " + operatorName);
		}
		return op;
	}
	
}

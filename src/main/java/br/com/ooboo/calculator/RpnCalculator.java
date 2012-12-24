package br.com.ooboo.calculator;

import java.math.BigDecimal;

import br.com.ooboo.calculator.operator.Add;
import br.com.ooboo.calculator.operator.Factorial;
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
		if ("+".equals(operatorName)) {
			new Add().execute(values);
		} else if ("-".equals(operatorName)) {
			new Subtract().execute(values);
		} else if ("!".equals(operatorName)) {
			new Factorial().execute(values);
		} else {
			throw new NoSuchOperatorException(
					"Invalid operator named: " + operatorName);
		}
	}
	
}

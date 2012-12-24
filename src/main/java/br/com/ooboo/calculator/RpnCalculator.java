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

	private void add() {
		new Add().execute(values);
	}

	private void subtract() {
		new Subtract().execute(values);
	}

	private void factorial() {
		new Factorial().execute(values); 
	}

	public void execute(String operatorName) {
		if ("+".equals(operatorName)) {
			add();
		} else if ("-".equals(operatorName)) {
			subtract();
		} else if ("!".equals(operatorName)) {
			factorial();
		} else {
			throw new NoSuchOperatorException(
					"Invalid operator named: " + operatorName);
		}
	}
	
}

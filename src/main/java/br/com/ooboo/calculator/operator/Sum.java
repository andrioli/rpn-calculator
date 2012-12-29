package br.com.ooboo.calculator.operator;

import br.com.ooboo.calculator.OperandStack;

public class Sum implements MathOperator {

	@Override
	public void execute(OperandStack values) {
		while (values.size() > 1) {
			new Add().execute(values);
		}
	}

}

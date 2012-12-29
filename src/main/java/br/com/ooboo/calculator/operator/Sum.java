package br.com.ooboo.calculator.operator;

import br.com.ooboo.calculator.OperandStack;

public class Sum implements MathOperator {

	private static final Add ADD = new Add();

	@Override
	public void execute(OperandStack values) {
		while (values.size() > 1) {
			ADD.execute(values);
		}
	}

}

package br.com.ooboo.calculator.operator;

import br.com.ooboo.calculator.OperandStack;

public interface MathOperator {

	void execute(OperandStack values);

}
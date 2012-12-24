package br.com.ooboo.calculator.operator;

import java.math.BigDecimal;

import br.com.ooboo.calculator.OperandStack;

public class Subtract implements MathOperator {
	
	@Override
	public void execute(OperandStack values) {
		BigDecimal rhs = values.peek();
		values.pop();
		BigDecimal lhs = values.peek();
		BigDecimal value = lhs.subtract(rhs);
		values.replaceTop(value);
	}

}

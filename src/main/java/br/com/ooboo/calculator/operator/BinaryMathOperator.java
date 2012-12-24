package br.com.ooboo.calculator.operator;

import java.math.BigDecimal;

import br.com.ooboo.calculator.OperandStack;

public abstract class BinaryMathOperator implements MathOperator {

	@Override
	public final void execute(OperandStack values) {
		BigDecimal rhs = values.peek();
		values.pop();
		BigDecimal lhs = values.peek();
		BigDecimal result = executeImplementation(lhs, rhs);
		values.push(result);
	}

	protected abstract BigDecimal executeImplementation(BigDecimal lhs, BigDecimal rhs);
	
}

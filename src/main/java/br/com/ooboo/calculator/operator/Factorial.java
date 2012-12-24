package br.com.ooboo.calculator.operator;

import java.math.BigDecimal;

import br.com.ooboo.calculator.OperandStack;

public class Factorial implements MathOperator {

	@Override
	public void execute(OperandStack values) {
		BigDecimal operand = values.peek();
		BigDecimal result = BigDecimal.ONE;
		
		while (operand.compareTo(BigDecimal.ONE) > 0) {
			result = result.multiply(operand);
			operand = operand.subtract(BigDecimal.ONE);
		}
		
		values.replaceTop(result);
	}

}

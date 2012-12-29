package br.com.ooboo.calculator.operator;

import java.math.BigDecimal;

import br.com.ooboo.calculator.OperandStack;

public class PrimeFactors implements MathOperator {

	private static final BigDecimal TWO = new BigDecimal(2);

	@Override
	public void execute(OperandStack values) {
		BigDecimal value = values.peek();
		values.pop();
		
		BigDecimal divisor = TWO;
		while (value.compareTo(divisor) >= 0) {
			while (value.remainder(divisor).equals(BigDecimal.ZERO)) {
				values.push(divisor);
				value = value.divide(divisor);
			}
			divisor = divisor.add(BigDecimal.ONE);
		}
			
		if (value.compareTo(TWO) >= 0)
			values.push(value);
	}

}

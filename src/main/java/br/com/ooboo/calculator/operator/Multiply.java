package br.com.ooboo.calculator.operator;

import java.math.BigDecimal;

public class Multiply extends BinaryMathOperator {

	@Override
	protected BigDecimal executeImplementation(BigDecimal lhs, BigDecimal rhs) {
		return lhs.multiply(rhs);
	}

}

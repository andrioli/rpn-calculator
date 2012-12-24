package br.com.ooboo.calculator.operator;

import java.math.BigDecimal;

public class Add extends BinaryMathOperator {
	
	@Override
	protected BigDecimal executeImplementation(BigDecimal lhs, BigDecimal rhs) {
		return lhs.add(rhs);
	}

}

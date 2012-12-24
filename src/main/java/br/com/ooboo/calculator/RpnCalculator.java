package br.com.ooboo.calculator;

import java.math.BigDecimal;

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

	public void add() {
		BigDecimal rhs = getAccumulator();
		values.pop();
		BigDecimal lhs = getAccumulator();
		BigDecimal value = lhs.add(rhs);
		setAccumulator(value);
	}

	public void subtract() {
		BigDecimal rhs = getAccumulator();
		drop();
		BigDecimal lhs = getAccumulator();
		BigDecimal value = lhs.subtract(rhs);
		setAccumulator(value);
	}

	public void factorial() {
		BigDecimal operand = getAccumulator();
		BigDecimal result = BigDecimal.ONE;
		
		while (operand.compareTo(BigDecimal.ONE) > 0) {
			result = result.multiply(operand);
			operand = operand.subtract(BigDecimal.ONE);
		}
		
		setAccumulator(result);
	}
	
}

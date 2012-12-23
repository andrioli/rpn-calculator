package br.com.ooboo.calculator;

import java.math.BigDecimal;
import java.util.Stack;

public class RpnCalculator {
	
	private Stack<BigDecimal> stack = new Stack<>();

	private BigDecimal accumulator = BigDecimal.ZERO;

	public BigDecimal getAccumulator() {
		return accumulator;
	}

	public void setAccumulator(BigDecimal value) {
		accumulator = value;
	}

	public void enter() {
		stack.push(accumulator);
	}

	public void drop() {
		if (!stack.isEmpty())
			accumulator = stack.pop();
		else
			accumulator = BigDecimal.ZERO;
	}
	
}

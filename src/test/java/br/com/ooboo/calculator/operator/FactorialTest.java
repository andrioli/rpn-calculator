package br.com.ooboo.calculator.operator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.ooboo.calculator.OperandStack;

public class FactorialTest {
	
	private Factorial op;
	private OperandStack stack;

	@Before
	public void init() {
		op = new Factorial();
		stack = new OperandStack();
	}
	
	@Test
	public void FactorialOf_0_Is_1() {
		op.execute(stack);
		assertEquals(BigDecimal.ONE, stack.peek());
	}

	@Test
	public void FactorialOf_5_Is_120() {
		stack.replaceTop(new BigDecimal(5));
		op.execute(stack);
		assertEquals(new BigDecimal(120), stack.peek());
	}

}

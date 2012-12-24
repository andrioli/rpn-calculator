package br.com.ooboo.calculator.operator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.ooboo.calculator.OperandStack;

public class DivideTest {
	@Test
	public void ShouldDivideCorrectly() {
		OperandStack stack = new OperandStack();
		stack.push(new BigDecimal(12));
		stack.push(new BigDecimal(2));
		
		Divide op = new Divide();
		
		op.execute(stack);
		
		assertEquals(new BigDecimal(6), stack.peek());
	}
	
	@Test(expected=ArithmeticException.class)
	public void ShouldThrowExceptionWhendDivideByZero() {
		OperandStack stack = new OperandStack();
		stack.push(new BigDecimal(12));
		stack.push(new BigDecimal(0));
		
		Divide op = new Divide();
		
		op.execute(stack);
	}
}

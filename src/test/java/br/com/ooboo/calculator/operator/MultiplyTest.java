package br.com.ooboo.calculator.operator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.ooboo.calculator.OperandStack;

public class MultiplyTest {

	@Test
	public void ShouldMultiplyCorrectly() {
		OperandStack stack = new OperandStack();
		stack.push(new BigDecimal(12));
		stack.push(new BigDecimal(2));
		
		Multiply op = new Multiply();
		
		op.execute(stack);
		
		assertEquals(new BigDecimal(24), stack.peek());
	}
	
}

package br.com.ooboo.calculator.operator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.ooboo.calculator.OperandStack;

public class SumTest {
	
	@Test
	public void ShouldBeAbleToSumThreeValues() {
		OperandStack stack = new OperandStack();
		
		stack.push(new BigDecimal(3));
		stack.push(new BigDecimal(4));
		stack.push(new BigDecimal(5));
		
		new Sum().execute(stack);
		
		assertEquals(new BigDecimal(12), stack.peek());
	}

}

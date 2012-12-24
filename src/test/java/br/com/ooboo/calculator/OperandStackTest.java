package br.com.ooboo.calculator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class OperandStackTest {
	
	private OperandStack values;
	
	@Before
	public void init() {
		values = new OperandStack();
	}
	
	@Test
	public void IsNeverEmpty() {
		assertEquals(BigDecimal.ZERO, values.peek());
	}
	
	@Test
	public void CanReplaceTopValueOfAnEmptyStack() {
		values.replaceTop(BigDecimal.TEN);
		assertEquals(BigDecimal.TEN, values.peek());
	}
	
	@Test
	public void CanHaveValuesPushed() {
		values.push(BigDecimal.ONE);
		assertEquals(BigDecimal.ONE, values.peek());
	}
	
	@Test
	public void TopValueRemovedOnPop() {
		values.replaceTop(new BigDecimal(19));
		values.pop();
		assertEquals(BigDecimal.ZERO, values.peek());
	}
	
	@Test
	public void PopCanBeCalledWhenEmpty() {
		values.pop();
	}
	
	@Test
	public void CanReplaceTopCorrectly() {
		values.push(BigDecimal.TEN);
		values.replaceTop(BigDecimal.ONE);
		assertEquals(BigDecimal.ONE, values.peek());
	}

}

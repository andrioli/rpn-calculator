package br.com.ooboo.calculator.operator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.ooboo.calculator.OperandStack;

import static org.mockito.Mockito.*;

public class ABinaryMathOperatorShould {

	private BinaryMathOperator mockOp;
	
	private OperandStack stackMock;
	
	BigDecimal lhs = new BigDecimal(9);
	BigDecimal rhs = new BigDecimal(-4);
	
	@Before
	public void init() {
		mockOp = mock(BinaryMathOperator.class);
		stackMock = mock(OperandStack.class);
		
		when(stackMock.peek())
			.thenReturn(rhs)
			.thenReturn(lhs);
		
		when(mockOp.executeImplementation(
				any(BigDecimal.class), 
				any(BigDecimal.class)))
			.thenReturn(BigDecimal.ONE);
	}

	@Test
	public void AquireTwoParametersFromStack() {
		mockOp.execute(stackMock);
		verify(stackMock, times(2)).peek();
		verify(stackMock, times(1)).pop();
	}
	
	@Test
	public void ExecuteExtensionPoint() {
		mockOp.execute(stackMock);
		verify(mockOp, times(1)).executeImplementation(lhs, rhs);
	}
	
	@Test
	public void StoreResultsOnStack() {
		mockOp.execute(stackMock);
		verify(stackMock, times(1)).replaceTop(BigDecimal.ONE);
	}
	
	@Test
	public void ShouldReduceStackSizeBy1() {
		OperandStack stack = new OperandStack();
		stack.push(BigDecimal.ONE);
		stack.push(BigDecimal.ONE);
		
		mockOp.execute(stack);
		
		assertEquals(1, stack.size());
	}
}

package br.com.ooboo.calculator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ACalculatorWithThreeValuesShould {

	private RpnCalculator calculator;
	
	BigDecimal value1 = new BigDecimal(42);
	BigDecimal value2 = new BigDecimal(2);
	BigDecimal value3 = new BigDecimal(3);
	
	@Before
	public void init() {
		calculator = new RpnCalculator();
		calculator.setAccumulator(value1);
		calculator.enter();
		calculator.setAccumulator(value2);
		calculator.enter();
		calculator.setAccumulator(value3);
	}

	@Test
	public void HaveTheLastValueEnteredInItsAccumulator() {
		assertEquals(value3, calculator.getAccumulator());
	}
	
	@Test
	public void HaveTheSecondToLastValueAfterASingleDrop() {
		calculator.drop();
		assertEquals(value2, calculator.getAccumulator());
	}
	
	@Test
	public void HaveTheFirstValueEnteredAfterTwoDrops() {
		calculator.drop();
		calculator.drop();
		assertEquals(value1, calculator.getAccumulator());
	}
	
	@Test
	public void Have0AfterThreeDrops() {
		calculator.drop();
		calculator.drop();
		calculator.drop();
		assertEquals(BigDecimal.ZERO, calculator.getAccumulator());
	}
	
}

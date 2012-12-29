package br.com.ooboo.calculator.operator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ShortNamedMathOperatorFactory implements MathOperatorFactory {
	
	private Map<String, MathOperator> operatorsByName;
	
	public ShortNamedMathOperatorFactory() {
		operatorsByName = new ConcurrentHashMap<>();
		registerOperators();
	}
	
	private void registerOperators() {
		operatorsByName.put("+", new Add());
		operatorsByName.put("-", new Subtract());
		operatorsByName.put("*", new Multiply());
		operatorsByName.put("/", new Divide());
		operatorsByName.put("!", new Factorial());
		operatorsByName.put("sum", new Sum());
		operatorsByName.put("primeFactors", new PrimeFactors());
	}

	@Override
	public MathOperator findOperatorNamed(String operatorName) {
		MathOperator op = operatorsByName.get(operatorName);
		
		if (op == null){
			throw new NoSuchOperatorException(
					"Invalid operator named: " + operatorName);
		}
		
		return op;
	}	

}

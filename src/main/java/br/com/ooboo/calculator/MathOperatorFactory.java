package br.com.ooboo.calculator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import br.com.ooboo.calculator.operator.Add;
import br.com.ooboo.calculator.operator.Divide;
import br.com.ooboo.calculator.operator.Factorial;
import br.com.ooboo.calculator.operator.MathOperator;
import br.com.ooboo.calculator.operator.Multiply;
import br.com.ooboo.calculator.operator.NoSuchOperatorException;
import br.com.ooboo.calculator.operator.Subtract;

public class MathOperatorFactory {
	
	private Map<String, MathOperator> operatorsByName;
	
	public MathOperatorFactory() {
		operatorsByName = new ConcurrentHashMap<>();
		registerOperators();
	}
	
	private void registerOperators() {
		operatorsByName.put("+", new Add());
		operatorsByName.put("-", new Subtract());
		operatorsByName.put("*", new Multiply());
		operatorsByName.put("/", new Divide());
		operatorsByName.put("!", new Factorial());
	}

	public MathOperator findOperatorNamed(String operatorName) {
		MathOperator op = operatorsByName.get(operatorName);
		
		if (op == null){
			throw new NoSuchOperatorException(
					"Invalid operator named: " + operatorName);
		}
		
		return op;
	}	

}

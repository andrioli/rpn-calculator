package br.com.ooboo.calculator;

import br.com.ooboo.calculator.operator.Add;
import br.com.ooboo.calculator.operator.Divide;
import br.com.ooboo.calculator.operator.Factorial;
import br.com.ooboo.calculator.operator.MathOperator;
import br.com.ooboo.calculator.operator.Multiply;
import br.com.ooboo.calculator.operator.NoSuchOperatorException;
import br.com.ooboo.calculator.operator.Subtract;

public class MathOperatorFactory {
	
	public MathOperator findOperatorNamed(String operatorName) {
		MathOperator op = null;
		
		if ("+".equals(operatorName)) {
			op = new Add();
		} else if ("-".equals(operatorName)) {
			op = new Subtract();
		} else if ("!".equals(operatorName)) {
			op = new Factorial();
		} else if ("*".equals(operatorName)) {
			op = new Multiply();
		} else if ("/".equals(operatorName)) {
			op = new Divide();
		} else {
			throw new NoSuchOperatorException(
					"Invalid operator named: " + operatorName);
		}
		return op;
	}	

}

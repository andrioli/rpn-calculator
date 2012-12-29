package br.com.ooboo.calculator.operator;

public interface MathOperatorFactory {

	MathOperator findOperatorNamed(String operatorName);

}

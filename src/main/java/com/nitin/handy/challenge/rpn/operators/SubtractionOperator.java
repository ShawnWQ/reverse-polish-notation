package com.nitin.handy.challenge.rpn.operators;

import java.util.Deque;

/**
 * SubtractOperator class represents the - operator
 * 
 * Pop 2 elements off the stack and returns the result of the subtraction
 * 
 * @author nitin
 *
 */
public class SubtractionOperator implements RpnOperator {

	@Override
	public Double apply(Deque<Double> stack) {
		Double operand2 = stack.pop();

		Double operand1 = stack.pop();
		
		return operand1 - operand2;
	}
	

}

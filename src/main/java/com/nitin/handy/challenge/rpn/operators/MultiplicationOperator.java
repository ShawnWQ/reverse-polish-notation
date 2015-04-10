package com.nitin.handy.challenge.rpn.operators;

import java.util.Deque;

/**
 * MultiplicationOperator class represents the - operator
 * 
 * Pop 2 elements off the stack and returns the result of the multiplication
 * 
 * @author nitin
 *
 */
public class MultiplicationOperator implements RpnOperator {
	
	@Override
	public Double apply(Deque<Double> stack) {
		Double operand1 = stack.pop();
		
		Double operand2 = stack.pop();
		
		return operand1 * operand2;
	}

}

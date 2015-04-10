package com.nitin.handy.challenge.rpn.operators;

import java.util.Deque;

/**
 * AddOperator class represents the + operator
 * 
 * It pops 2 elements off the stack returns the sum of the 2 elements
 * 
 * @author nitin
 *
 */
public class AdditionOperator implements RpnOperator{

	@Override
	public Double apply(Deque<Double> stack) {
		Double operand1 = stack.pop();
		
		Double operand2 = stack.pop();
		
		return operand1 + operand2;
	}

	
}


package com.nitin.handy.challenge.rpn.operators;

import java.util.Deque;

import com.nitin.handy.challenge.rpn.exceptions.DivideByZeroException;

/**
 * DivisionOperator class represents the - operator
 * 
 * Pop 2 elements off the stack and returns the result of the division
 * 
 * @author nitin
 *
 */
public class DivisionOperator implements RpnOperator {
	
	@Override
	public Double apply(Deque<Double> stack) throws Exception {
		Double operand2 = stack.pop();

		Double operand1 = stack.pop();
		
		if(new Double(0).equals(operand2))
			throw new DivideByZeroException();
		
		return operand1 / operand2;
	}

}

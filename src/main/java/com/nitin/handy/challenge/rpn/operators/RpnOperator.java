package com.nitin.handy.challenge.rpn.operators;

import java.util.Deque;

/**
 * RpnOperator interface represents all operators that can be used in our RpnEvaluator
 * 
 * @author nitin
 *
 */
public interface RpnOperator {
	
	public Double apply(Deque<Double> stack) throws Exception;
	
	

}

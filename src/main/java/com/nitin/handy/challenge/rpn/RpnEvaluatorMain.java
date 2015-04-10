package com.nitin.handy.challenge.rpn;

/**
 * A Main method that acts as a driver program for our Reverse Polish Notation evaluator
 * @author nitin
 *
 */
public class RpnEvaluatorMain {
	
	public static void main(String[] args) throws Exception {
		RpnEvaluator evaluator = new RpnEvaluator();
		
		System.out.println(evaluator.evaluate("(2 3 + 5 + 10 -)"));
		
		System.out.println(evaluator.evaluate("(2 2 2 * * 3 +)"));
	}

}

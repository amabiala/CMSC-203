/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author Andrea
 */
public class Function3 extends Function {
    @Override
	public double fnValue(double x) {
		return (8*x-Math.sqrt(x))/(Math.pow(x,3) - (7*Math.pow(x,2)) + 15*x - 9);
	}
	
	public String toString () {
		return "(8*x-sqrt(x))/x^3 - 7*x^2 + 15*x - 9";
	}
}

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
public class Function1 extends Function {
    @Override
	public double fnValue(double x) {
		if (x==0.0) 
			return Double.MAX_VALUE;
		else 
			return 1/x;
	}
	
	public String toString() {
		return "1/x";
	}
}

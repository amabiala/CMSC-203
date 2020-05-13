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
public class Function5 extends Function {
    
    public double fnValue(double x) {
        
        double function = 1/x;
		if (x==0.0) {
			function = Double.MAX_VALUE;
                }
		
                return Math.sin(function);
	}
	
	public String toString() {
		return "sin(1/x)";
	}    
}

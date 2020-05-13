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
public class Function2 extends Function {
    @Override
	public double fnValue(double x) {
		return Math.sin(x);
	}
	
	public String toString() {
		return "sin(x)";
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javax.swing.JFrame;

public class ATMSim{
	//run the program
	public static void main(String[] args) {
		GridLayoutFrame gridlayout = new GridLayoutFrame();
		gridlayout.run();
		gridlayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridlayout.setSize(800, 500);
		gridlayout.setVisible(true);
	}
	
}

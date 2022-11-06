package com.perisic.uob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Example class to demonstrate three different version of ActionListener implementation
 * @author Marc Conrad
 *
 */

public class SimpleGUI extends JFrame implements ActionListener {


	private static final long serialVersionUID = -107785653904236635L;
	/**
	 * Method that is called when button One is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		if( e.getSource().equals(btn1)) { 
			JOptionPane.showMessageDialog(null, "Button ONE has been pressed");
		}else if(e.getSource().equals(btn4)) {
			JOptionPane.showMessageDialog(null, "Button FOUR has been pressed");
		}
		else { 
			// some other action has happened
		}
	}

	JButton btn1, btn2, btn3, btn4, btn5, btn6; 


	public SimpleGUI() {
		super();
		setSize(400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 

		btn1 = new JButton("One"); 
		btn2 = new JButton("Two"); 
		btn3 = new JButton("Three"); 
		btn4 = new JButton("Four"); 
		btn5 = new JButton("Five"); 
		btn6 = new JButton("Six"); 


		panel.add(btn1); 
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		

		// Method one: attach this object as the Action Listener
		btn1.addActionListener(this); 

		// Method two: attach a different object as the Action listener
		btn2.addActionListener(new Btn2ActionListener() ); 

		// Method three: declare the action listener inline as an anonymous object.
		btn3.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent evt ) { 
				JOptionPane.showMessageDialog(null, "Button THREE has been pressed.");
			}
		}
				); 
		
		// Method one: attach this object as the Action Listener
		btn4.addActionListener(this); 

		// Method two: attach a different object as the Action listener
		btn5.addActionListener(new Btn5ActionListener()); 

		// Method three: declare the action listener inline as an anonymous object.
		btn6.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent evt ) { 
				JOptionPane.showMessageDialog(null, "Button Six has been pressed.");
			}
		}
				); 


		getContentPane().add(panel);
		panel.repaint();
	}
	/**
	 * Start the programme here.
	 * @param args not used.
	 */
	public static void main(String [] args ) { 
		SimpleGUI myGUI = new SimpleGUI(); 
		myGUI.setVisible(true); 

	}

}

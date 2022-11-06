package com.perisic.beds.peripherals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.perisic.beds.recycling.CustomerPanel;
import com.perisic.beds.recycling.ReceiptPrinter;
/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * This class combines three different aspects: 
 * 1) Starting the software
 * 2) Implementing the GUI
 * 3) Handling events
 * 4) Handling output
 *  
 * @author Marc Conrad
 *
 */
public class RecyclingGUI extends JFrame implements ActionListener, ReceiptPrinter  {

	private static final long serialVersionUID = -1077856539035586635L;
	
	/**
	 * Method that is called when an item has been entered into the machine or a receipt has been requested.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource().equals(slot1)) { 
			theRecyclingMachine.itemReceived(1);
		} else if( e.getSource().equals(slot2)) { 
			theRecyclingMachine.itemReceived(2);
		} else if(e.getSource().equals(slot3)) { 
			theRecyclingMachine.itemReceived(3);
		} else if(e.getSource().equals(receipt)) { 
			theRecyclingMachine.printReceipt();
		}
	}

	JButton slot1 = new JButton("Can"); 
	JButton slot2 = new JButton("Bottle"); 
	JButton slot3 = new JButton("Crate"); 

	JButton receipt = new JButton("Receipt"); 
	JTextArea outputWindow = new JTextArea(10,25);
	
	CustomerPanel theRecyclingMachine = null;
/**
 * Constructor; sets up GUI.
 */
	public RecyclingGUI() {
		super();
		setSize(350,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.add(slot1); 
		panel.add(slot2);
		panel.add(slot3); 

		slot1.addActionListener(this); 
		slot2.addActionListener(this); 
		slot3.addActionListener(this); 

		panel.add(receipt); 
		receipt.addActionListener(this); 

		JScrollPane scrollPane = new JScrollPane(outputWindow); 		
		outputWindow.setEditable(false);
		
		outputWindow.setText("Welcome to the Recycling Machine!");
		//outputWindow.setSize(330, 600);
		panel.add(scrollPane);

		getContentPane().add(panel);
		panel.repaint();
		
		theRecyclingMachine = new CustomerPanel(this); 
	}
	/**
	 * Main entry point into the recycling machine.
	 * @param args not used.
	 */
	public static void main(String [] args ) { 
		RecyclingGUI myGUI = new RecyclingGUI(); 
		myGUI.setVisible(true); 

	}
	
	/**
	 * Prints text in the output window.                       
	 */
	@Override
	public void print(String str) { 
			outputWindow.setText(str); 
			outputWindow.repaint();
		
		
	}

}
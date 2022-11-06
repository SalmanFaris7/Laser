package com.perisic.beds.peripherals;
import com.perisic.beds.recycling.*;
/**
 * Tests the recycling machine.
 * @author Marc Conrad
 *
 */
public class BasicTester {
/**
 * Start the tester here.  
 */
	public static void main(String [] args) { 

		ReceiptPrinter myPrinter = new BasicPrinter(); 

		CustomerPanel myPanel = new CustomerPanel(myPrinter); 
		myPanel.itemReceived(1);
		myPanel.itemReceived(1);
		myPanel.itemReceived(3);
		myPanel.itemReceived(2);
		myPanel.itemReceived(3);
		myPanel.itemReceived(1); 
		myPanel.itemReceived(1);
		
		myPanel.printReceipt();
	}
}

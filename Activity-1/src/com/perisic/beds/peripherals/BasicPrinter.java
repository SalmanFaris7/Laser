package com.perisic.beds.peripherals;
import com.perisic.beds.recycling.ReceiptPrinter;

/**
 * Simulates a very simple printer that prints out stuff.
 * @author Marc Conrad
 *
 */
public class BasicPrinter implements ReceiptPrinter {
	/**
	 * @param str
	 */
	public void print(String str) { 
		// add code here to work with a real printer... 
		System.out.println(str);
	}
}

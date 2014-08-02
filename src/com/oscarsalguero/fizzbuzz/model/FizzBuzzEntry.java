package com.oscarsalguero.fizzbuzz.model;

import java.io.Serializable;

/**
 * A Java Object used to hold data.
 * 
 * @author Oscar Salguero <info@realactionsoft.com>
 * @version 2014.0730
 * @since 1.0
 */
public class FizzBuzzEntry implements Serializable {
	
	private static final long serialVersionUID = 5847996512001431001L;

	/**
	 * Used to hold the original number.
	 */
	private String number;
	
	/**
	 * Used to hold what the output generated after the number went trough the Fizz Buzz.
	 */
	private String output;
	
	public FizzBuzzEntry(String number, String output) {
		this.number = number;
		this.output = output;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
	
	@Override
	public String toString() {
		return output;
	}

}

package game;

import javax.swing.*;

public class BoardCell extends JLabel {
	private int value;

	public BoardCell(int value){
		this.setValue(value);
	}

	public BoardCell() {
	}

	/**
	 * The function returns the value of an integer.
	 *
	 * @return The method `getValue()` is returning an integer value. The specific value being returned
	 * depends on the value of the variable `value`.
	 */
	public int getValue(){
		return value;
	}

	/**
	 * This Java function sets the value of a variable.
	 *
	 * @param value The parameter "value" is an integer that is passed to the method. The method then sets
	 * the value of the instance variable "value" to the passed integer value.
	 */
	public void setValue(int value){
		this.value = value;
	}


	/**
	 * The function checks if a value is equal to a constant representing empty.
	 *
	 * @return A boolean value indicating whether the "value" variable is equal to the constant "EMPTY".
	 */
	public boolean isEmpty(){
		return value == Constants.EMPTY;
	}

	/**
	 * This function returns a string representation of a value based on certain conditions.
	 *
	 * @return A string representation of the value of a game piece on a board. If the value is empty, a
	 * space is returned. If the value is black, "B" is returned. If the value is white, "W" is returned.
	 */
	public String toString(){
		return (value == Constants.EMPTY) ? " " :
					value == Constants.BLACK ? "B" :
						"W";
	}
}
///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment5.java
// File:               Item
// Quarter:            (CSE 8B) Fall 2020
//
// Author:             Mingyi Li mil011@ucsd.edu
// Instructor's Name:  Professor Ben Ochoa
//
/**
 * Item builds an object Item with its attributes and getters and setters.
 *
 * @author Mingyi
 */
public class Item{
	private String name;

	public Item () {
		this.name = "item";
	}

	public Item(String name) {
		this.name = name;
	}
/**
 * getName() gets the name of item
 *
 * @param none
 * @return String that represents the name
 */
	public String getName() {
		return name;
	}
/**
 * setName() changes the name of item
 *
 * @param name: a new String of name
 * @return none
 */
	public void setName(String name) {
		this.name = name;
	}

}
///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment5.java
// File:               Pokemon
// Quarter:            (CSE 8B) Fall 2020
//
// Author:             Mingyi Li mil011@ucsd.edu
// Instructor's Name:  Professor Ben Ochoa
//
/**
 * Pokemon builds an object Pokemon with its attributes and getters and setters.
 *
 * @author Mingyi
 */
public class Pokemon {

	private String name;
	private String sound;
	private String type;

	public Pokemon() {
		name = "Pokemon";
		sound = "sound";
		type = "unknown";
	}

	public Pokemon(String name, String sound, String type) {
		this.name = name;
		this.sound = sound;
		this.type = type;
	}
/**
 * getName() gets the name of pokemon
 *
 * @param none
 * @return String that represents the name
 */
	public String getName() {
		return name;
	}
/**
 * setName() changes the name of pokemon
 *
 * @param name: a new String of name
 * @return none
 */
	public void setName(String name) {
		this.name = name;
	}

/**
 * getSound() gets the sound of pokemon
 *
 * @param none
 * @return String that represents the sound
 */
	public String getSound() {
		return sound;
	}
/**
 * setSound() changes the sound of pokemon
 *
 * @param sound: a String of new sound
 * @return none
 */
	public void setSound(String sound) {
		this.sound = sound;
	}

/**
 * getType() gets the type of pokemon
 *
 * @param none
 * @return String that represents the type
 */
	public String getType() {
		return type;
	}
/**
 * setType() changes the type of pokemon
 *
 * @param type: a new String of type
 * @return none
 */
	public void setType(String type) {
		this.type = type;
	}
	
/**
 * speak() gets the sound of pokemon
 *
 * @param none
 * @return none
 */
	public void speak() {
		System.out.println(this.name + ": " + this.sound + "!\n");
	}

}
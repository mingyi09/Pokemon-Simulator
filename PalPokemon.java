///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment5.java
// File:               PalPokemon
// Quarter:            (CSE 8B) Fall 2020
//
// Author:             Mingyi Li mil011@ucsd.edu
// Instructor's Name:  Professor Ben Ochoa
//
/**
 * PalPokemon builds an object PalPokemon inherited from Pokemon class with its attributes and getters and setters.
 *
 * @author Mingyi
 */
public class PalPokemon extends Pokemon{
    private String pokeballName;

    public PalPokemon() {
        pokeballName = "undefined";
    }

    public PalPokemon(String name, String sound, String type, String pokeballName) {
        setName(name);
		setSound(sound);
		setType(type);
		this.pokeballName = pokeballName;
    }
/**
 * getPokeballName() gets the name of Pokeball
 *
 * @param none
 * @return String that represents the name
 */
    public String getPokeballName() {
        return pokeballName;
    }
/**
 * getName() sets the name of Pokeball
 *
 * @param pokeballName: a String of new name
 * @return none
 */
    public void setPokeballName(String pokeballName) {
        this.pokeballName = pokeballName;
    }

/**
 * comesOutFromBall() checks PalPokemon of its name, type, and sound
 *
 * @param none
 * @return none
 */
    public void comesOutFromBall(){
        System.out.println(getName()+" in "+getPokeballName()+", "+getType()+".");
		speak();
    }
}

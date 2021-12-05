///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment5.java
// File:               WildPokemon
// Quarter:            (CSE 8B) Fall 2020
//
// Author:             Mingyi Li mil011@ucsd.edu
// Instructor's Name:  Professor Ben Ochoa
//
/**
 * WildPokemon builds an object WildPokemon inherited from Pokemon with its attributes and method check if it's caught
 *
 * @author Mingyi
 */
import java.util.Random;

public class WildPokemon extends Pokemon{
    private int patience;
    private int speed;
    private int timesEscapedFromBall;

    public WildPokemon() {
        patience = 100;
		speed = 0;
		timesEscapedFromBall = 0;
    }

    public WildPokemon(String name, String sound, String type, int patience, int speed){
        setName(name);
		setSound(sound);
		setType(type);
		this.patience = patience;
		this.speed = speed;	
    }
/**
 * getPatience() returns the WildPokemon's patience
 *
 * @param none
 * @return patience of the WildPokemon
 */
    public int getPatience() {
        return patience;
    }
/**
 * setPatience() changes the WildPokemon's patience
 *
 * @param patience the new patience
 * @return none
 */
    public void setPatience(int patience) {
        this.patience = patience;
    }
/**
 * getSpeed() returns the WildPokemon's speed
 *
 * @param none
 * @return speed of the WildPokemon
 */
    public int getSpeed() {
        return speed;
    }
/**
 * setSpeed() changes the WildPokemon's speed
 *
 * @param speed
 * @return none
 */
    public void setSpeed(int speed) {
		this.speed = speed;
    }
/**
 * getTimesEscapedFromBall() returns the WildPokemon's escape times
 *
 * @param none
 * @return times of escape from the pokeball
 */
    public int getTimesEscapedFromBall() {
        return timesEscapedFromBall;
    }
/**
 * setTimesEscapedFromBall() changes the WildPokemon's escape times
 *
 * @param timesEscapedFromBall
 * @return none
 */
    public void setTimesEscapedFromBall(int timesEscapedFromBall) {
		this.timesEscapedFromBall = timesEscapedFromBall;
    }
	
/**
 * isCaught checks if the WildPokemon is caught by the ball via comparing patience and speed
 *
 * @param berry The item used to enhance probability
 * @param pokeball The pokeball used to catch WildPokemon
 * @return boolean True if caught, false otherwise
 */

    public boolean isCaught(Berry berry, Pokeball pokeball) {
        Random rand = new Random(); //instance of random class
        int upperbound = 101;
        //generate random values from 0-100
        int ballSpeed = rand.nextInt(upperbound); //a random ballspeed
		int currentSpeed = speed - berry.getSpeedDecrement();
		int finalPatience = patience + berry.getPatienceIncrement() + pokeball.getPerformance();
		int patienceNeed = rand.nextInt(101); //a random required patience
		
		if (ballSpeed>currentSpeed){
			System.out.println("BallSpeed: "+ballSpeed); //random
			System.out.println(getName()+"'s speed: "+currentSpeed);
			System.out.println("Your "+pokeball.getName()+" hit "+getName()+"!");
			System.out.println();
			System.out.println("Patience need: "+patienceNeed);
			System.out.println(getName()+"'s patience: "+patience);
		    System.out.println(berry.getName()+"'s patience increment: "+berry.getPatienceIncrement());
			System.out.println(berry.getName()+"'s speed decrement: "+berry.getSpeedDecrement());
			System.out.println(pokeball.getName()+"'s performance: "+pokeball.getPerformance());
			if (finalPatience>=patienceNeed){
				System.out.println("Your "+pokeball.getName()+" caught "+getName()+"!");
				return true;
			}
			else{
				timesEscapedFromBall++;
				System.out.println(getName()+" escaped from your "+pokeball.getName()+"!");
			}
		}
		else{
			System.out.println("BallSpeed: "+ballSpeed); //random
			System.out.println(getName()+"'s speed: "+currentSpeed);
			System.out.println("Your "+pokeball.getName()+" missed "+getName()+"!");
		}
		
		return false;	
    }
/**
 * appear() makes the pokemon appear with its sound
 *
 * @param none
 * @return none
 */
    public void appear() {
        System.out.println("You encounter a wild "+getName()+"!");
		speak();
    }
/**
 * disappear() decides if the WildPokemon will disappear by patience and timesEscapedFromBall
 *
 * @param none
 * @return true if disappears, false otherwise
 */
    public boolean disappear() {
        if (patience<=0||timesEscapedFromBall>3){
			return true;
		}
		else{
			return false;
		}		
    }

}

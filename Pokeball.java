///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment5.java
// File:               Pokeball
// Quarter:            (CSE 8B) Fall 2020
//
// Author:             Mingyi Li mil011@ucsd.edu
// Instructor's Name:  Professor Ben Ochoa
//
/**
 * Pokeball builds an object Pokeball inherited from Item class with its attributes and getters and setters.
 *
 * @author Mingyi
 */
public class Pokeball extends Item{
    private int performance;

    public Pokeball() {
        performance = 0; //higher, easier to catch
    }

    public Pokeball(String name, int performance) {
        setName(name);
		this.performance = performance;
    }
/**
 * getPerformance() gets the performance of pokeball
 *
 * @param none
 * @return integer that represents the performance
 */
    public int getPerformance() {
        return performance;
    }
	
/**
 * setPerformance() changes the performance of pokeball
 *
 * @param performance: a new integer that represents performance
 * @return none
 */
    public void setPerformance(int performance) {
        this.performance = performance;
    }
}

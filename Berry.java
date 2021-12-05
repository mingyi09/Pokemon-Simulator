///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment5.java
// File:               Berry
// Quarter:            (CSE 8B) Fall 2020
//
// Author:             Mingyi Li mil011@ucsd.edu
// Instructor's Name:  Professor Ben Ochoa
//
/**
 * Berry builds an object Berry inherited from Item class with its attributes and getters and setters.
 *
 * @author Mingyi
 */
public class Berry extends Item {
    private int patienceIncrement;
    private int speedDecrement;

    public Berry() {
        patienceIncrement = 0; //higher, easier to catch
		speedDecrement = 0; //higher, make slower, easier
    }

    public Berry(String name, int patienceIncrement, int speedDecrement) {
        setName(name);
		this.patienceIncrement = patienceIncrement;
		this.speedDecrement = speedDecrement;
    }
/**
 * getPatienceIncrement() adds the patience from Berry
 *
 * @param none
 * @return integer that represents the added patience
 */
    public int getPatienceIncrement() {
        return patienceIncrement;
    }
/**
 * setPatienceIncrement() changes the patienceIncrement from Pokemon
 *
 * @param patienceIncrement: the new patience addition
 * @return none
 */
    public void setPatienceIncrement(int patienceIncrement) {
        this.patienceIncrement = patienceIncrement;
    }
/**
 * getSpeedDecrement() decreases the speed from Pokemon
 *
 * @param none
 * @return integer that represents the speedDecrement
 */
    public int getSpeedDecrement() {
        return speedDecrement;
    }
/**
 * setSpeedDecrement() sets the speed deduced from Pokemon 
 *
 * @param speedDecrement: the new speed deduction
 * @return none
 */
    public void setSpeedDecrement(int speedDecrement) {
        this.speedDecrement = speedDecrement;
    }
}

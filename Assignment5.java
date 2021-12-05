///////////////////////////////////////////////////////////////////////////////
//                   
// Title:              Assignment5
// Files:              PA5
// Quarter:            (CSE 8b) Fall 2020
//
// Author:             Mingyi Li
// Email:              mil011@ucsd.edu
// Instructor's Name:  Professor Ben Ochoa

/**
 * Assignment5 simulates Pokemon Go game and users can use items and pokeballs to catch pokemons.
 *
 * @author Mingyi
 */
import java.util.Scanner;

public class Assignment5 {
	private static String[] pokeballNames = {"pokeball", "superball", "ultraball"};
	private static int[] pokeballPerformance = {0, 10, 30};



	private static String[] berryNames = {"Razz Berry", "Nanap Berry", "Golden Razz Berry"};
	private static final int RAZZ_BERRY_PATIENCE_INC = 10;
	private static final int NANAP_BERRY_SPEED_DEC = 10;
	private static final int GOLDEN_RAZE_BERRY_PATIENCE_INC = 30;

	private static String[] pokemonNames = {"Pikachu", "Bulbasaur", "Charmander", "Squirtle", "Mew"};
	private static String[] pokemonSounds = {"pikapika", "bulb", "char", "squir", "mew"};
	private static String[] pokemonTypes = {"electric", "grass", "fire", "water", "psychic"};
	private static int[] pokemonPatienceStats = {60, 50, 50, 50, 15};
	private static int[] pokemonSpeedStats = {25, 5, 20, 10, 50};

	private static final int PATIENCE_DEC_EACH_ESCAPE = 5; //the amount of patience the wild pokemon decreases if escaped from a pokeball
	private static final String PROMPT_MSG_START =
			"This is the start of your pokemon trainer journey.\n" +
			"You will encounter different pokemons.\n" +
			"You can throw different poke balls to catch them.\n" +
			"You can use Razz Berry or Golden Razz Berry to increase the catch rate.\n" +
			"You can use Nanap Berry to make the ball hit more easily.\n" +
			"Up to one berry per throw. Use the berry before your ball throw.\n";

	private static final String PROMPT_MSG_BERRY = "Which berry do you want to use? " +
			"Type skip if you are confident. (Razz Berry, Nanap Berry, Golden Razz Berry, skip)";
	private static final String PROMPT_MSG_BERRY_WRONG_INPUT = "Your berry input was not recognized. " +
			"Choose one from the following four options: Razz Berry, Nanap Berry, Golden Razz Berry, skip";
	private static final String PROMPT_MSG_POKEBALL =
			"Which pokeball do you want to use? (pokeball, superball, ultraball)";
	private static final String PROMPT_MSG_POKEBALL_WRONG_INPUT = "Your pokeball input was not recognized. " +
			"Choose one from the following four options: pokeball, superball, ultraball";
	private static final String PROMPT_MSG_CHECK_CAUGHT_POKEMONS = "Now let's check who're your pals now!\n";

/**
 * startYourJourney() begins a journey of catching WildPokemon and make them our own
 *
 * @param none
 * @return none
 */

	public static void startYourJourney() {

		PalPokemon[] myPalPokemons = {new PalPokemon(), new PalPokemon(), new PalPokemon(),new PalPokemon(),new PalPokemon()};
		// Start the user-machine interaction below
		Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
		System.out.println(PROMPT_MSG_START); // Prompt user

		for (int i = 0; i < pokemonNames.length; i++) {
			WildPokemon currentPokemon = new WildPokemon(pokemonNames[i],pokemonSounds[i],pokemonTypes[i],pokemonPatienceStats[i],pokemonSpeedStats[i]);
			System.out.println();
			currentPokemon.appear(); //encounter
			
			int check = 0; 
			int escape1 = 0;
			while (check==0){	
			System.out.println(PROMPT_MSG_BERRY); //which berry
			Berry currentBerry;		
			
			while (true){ //loop to choose a berry
			    String ans_Berry = myScanner.nextLine();	 
				if (ans_Berry.equals("Razz Berry")){
					currentBerry = new Berry(ans_Berry,RAZZ_BERRY_PATIENCE_INC,0);
					break;
				}
				else if (ans_Berry.equals("Nanap Berry")){
					currentBerry = new Berry(ans_Berry,0,NANAP_BERRY_SPEED_DEC);
					break;
				}
				else if (ans_Berry.equals("Golden Razz Berry")){
					currentBerry = new Berry(ans_Berry,GOLDEN_RAZE_BERRY_PATIENCE_INC,0);
					break;
				}
				else if (ans_Berry.equals("skip")){
					currentBerry = new Berry();
					break;
				}
				else {
					System.out.println();
					System.out.println(PROMPT_MSG_BERRY_WRONG_INPUT);
				}	
			}
			
			System.out.println();
			System.out.println(PROMPT_MSG_POKEBALL);	
			Pokeball currentBall = new Pokeball();
			
			while (true){  //loop for pokeballs 
				String ans_Ball = myScanner.nextLine();
				int index = -1;
				for (int j=0;j<pokeballNames.length;j++){
					if (ans_Ball.equals(pokeballNames[j])){
					    index = j;
					}
				}
				if (index ==-1){
					System.out.println();
					System.out.println(PROMPT_MSG_POKEBALL_WRONG_INPUT);		
					}
				else{
				currentBall.setName(pokeballNames[index]);
				currentBall.setPerformance(pokeballPerformance[index]);
				break;
				}
			}
			
			System.out.println();

			if (currentPokemon.isCaught(currentBerry,currentBall)){
				myPalPokemons[i].setPokeballName(currentBall.getName());
				myPalPokemons[i].setName(pokemonNames[i]);
				myPalPokemons[i].setSound(pokemonSounds[i]);
				myPalPokemons[i].setType(pokemonTypes[i]);
				check = 1; //end if caught
			}
			else{
				System.out.println();
				System.out.println(currentPokemon.getName()+"'s times escaped from ball: "+currentPokemon.getTimesEscapedFromBall());
				System.out.println();
				if (currentPokemon.getTimesEscapedFromBall() - escape1!=0){ 
				currentPokemon.setPatience(currentPokemon.getPatience()-PATIENCE_DEC_EACH_ESCAPE);
				}
				if (currentPokemon.disappear()){
					System.out.println(currentPokemon.getName()+" disappears...");
					check =1; //end if disappear	
				}
				//start a new round and clear berry&ball effects
				if (currentPokemon.getTimesEscapedFromBall() - escape1!=0){//avoid slower speed uncaught situation
				currentPokemon.setPatience(currentPokemon.getPatience()-currentBerry.getPatienceIncrement()-currentBall.getPerformance());
				currentPokemon.setSpeed(currentPokemon.getSpeed()+currentBerry.getSpeedDecrement());
				escape1 = currentPokemon.getTimesEscapedFromBall();
				}
			}
			} //end while loop			

		} //end for loop 

		// (Check all pokemon you just caught)
		System.out.println();
		System.out.println(PROMPT_MSG_CHECK_CAUGHT_POKEMONS);
		for (PalPokemon mypal: myPalPokemons){
			if (!mypal.getSound().equals("sound")){
			mypal.comesOutFromBall();
			}
		}
		myScanner.close(); //close the scanner
	}

/**
 * unitTests() performs tests on the code
 *
 * @param none
 * @return true if passed, false otherwise
 */
	public static boolean unitTests() {
		WildPokemon testW = new WildPokemon("testW","sound","type",5,5);
		Berry testB = new Berry("testB", 10, 2);
		Pokeball testBall = new Pokeball("testBall",8);
		//test case 1
		testW.setPatience(testW.getPatience()-5);
		if (!testW.disappear())
		{return false;}
		//test case 2
		if (!testW.getType().equals("type"))
		{return false;}
		//test case 3 
		if (!testBall.getName().equals("testBall"))
		{return false;}
		//test case 4
		if (testBall.getPerformance()!=8)
		{return false;}
		//test case 5
		if (testB.getPatienceIncrement()!=10)
		{return false;}
		//test case 6
		if (testB.getSpeedDecrement()!=2)
		{return false;}
		return true;
	}


	public static void main(String[] args) {

		// Perform unitTests first
		if(unitTests()) {
			System.out.println("All unit tests passed.\n");
		} else {
			System.out.println("Failed test.\n");
			return;
		}

		startYourJourney();
	}
}
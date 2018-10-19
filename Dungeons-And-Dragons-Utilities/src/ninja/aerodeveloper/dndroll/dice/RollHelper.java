/**
 * 
 */
package ninja.aerodeveloper.dndroll.dice;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Benjamin Law
 *
 */
public class RollHelper {
	private ArrayList<Dice> diceToRoll;
	
	/**
	 * 
	 */
	public RollHelper() {
		this(new ArrayList<Dice>());
	}
	
	/** TODO
	 * @param diceToRoll
	 */
	public RollHelper(ArrayList<Dice> diceToRoll) {
		this.diceToRoll = diceToRoll;
	}
	
	/**
	 * Adds die specified in argument to the set of Dice to roll.
	 * 
	 * @param die
	 *            the Dice enum which will be rolled in this set
	 */
	public void addDie(Dice die) {
		this.diceToRoll.add(die);
	}
	
	/**
	 * TODO
	 * @param name
	 */
	public void addDie(String name) {
		this.addDie(this.determineDice(name));
	}
	
	/**
	 * TODO
	 */
	public void clearDice() {
		this.diceToRoll = new ArrayList<Dice>();
	}
	
	/**
	 * TODO
	 * @param name
	 * @return
	 */
	public Dice determineDice(String name) {
		switch (name) {
		case "D4":
			return Dice.D4;
		case "D6":
			return Dice.D6;
		case "D8":
			return Dice.D8;
		case "D10":
			return Dice.D10;
		case "D12":
			return Dice.D12;
		case "D20":
			return Dice.D20;
		case "DP":
			return Dice.DPercent;
		default://TODO add error reporting here
			return null;
		}
	}
	
	/**
	 * Generates a random number and returns the value based on the possible options of the dice
	 * 
	 * @param dice
	 * @return
	 */
	public int roll(Dice dice) {
		int max = dice.getMaxValue() - dice.getMinValue() + 1;
		switch (dice) {
		case DPercent:
			return ((new Random().nextInt(max) + 1) * 10);		
		default:
			return new Random().nextInt(max) + 1;
		}
	}
	/**
	 * TODO
	 * @param name
	 * @return
	 */
	public int roll(String name) {
		return (roll(this.determineDice(name)));
	}
	
	
	/**
	 * TODO
	 * @return
	 */
	public int[] rollDice() {
		int[] results = new int[diceToRoll.size()];
		int i = 0;
		for (Dice dice : this.diceToRoll) {
			results[i++] = roll(dice);
		}
		return results;
	}
	
	/**
	 * TODO
	 * @param clearDice
	 * @return
	 */
	public int[] rollDice(boolean clearDice) {
		int[] results = this.rollDice();
		if(clearDice)
			this.clearDice();
		return results;
	}
	
}

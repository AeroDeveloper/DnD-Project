/**
 * 
 */
package ninja.aerodeveloper.dndroll.dice;

/**
 * @author Benjamin Law
 *
 */
public enum Dice {
	/**
	 * TODO
	 */
	D4(1, 4, 1,"D4"), 
	/**
	 * TODO
	 */
	D6(1, 6, 1,"D6"), 
	/**
	 * TODO
	 */
	D8(1, 8, 1,"D8"), 
	/**
	 * TODO
	 */
	D10(0, 9, 1,"D10"), 
	/**
	 * TODO
	 */
	DPercent(0, 9, 10,"DP"), 
	/**
	 * TODO
	 */
	D12(1, 12, 1,"D12"), 
	/**
	 * TODO
	 */
	D20(1, 20, 1,"D20");
	private int minValue, maxValue, increment;
	String name;
	
	private Dice(int minValue, int maxValue, int increment, String name) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.increment = increment;
		this.name = name;
	}
	
	/**
	 * Gets the increment by which this dice increases by for each sequential side.
	 * @return
	 */
	public int getIncrement() {
		return this.increment;
	}
	
	/**
	 * Returns the maximum possible value of this dice. Note that if 0 is the minimum, it is the true maximum and should be accounted for.
	 * 
	 * @return
	 */
	public int getMaxValue() {
		return this.maxValue;
	}
	/**
	 * Returns the minimum possible value of this dice. Note that 0 usually denotes the high value of this dice.
	 * 
	 * @return
	 */
	public int getMinValue() {
		return this.minValue;
	}
	
}

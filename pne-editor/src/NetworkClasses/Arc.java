package NetworkClasses;

public abstract class Arc {
	
	protected int weight;
	
	/*
	 * Description : returns the weight of the arc.
	 */
	public int getWeight() {
		return this.weight;
	}
	
	/*
	 * Description : sets the weight of the given arc.
	 */
	public void setWeight(int weight) {
		this.weight = Math.abs(weight);
	}
	
	public abstract boolean isIn();
}

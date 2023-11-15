package NetworkClasses;

import java.util.ArrayList;
public class Place extends Location {
	
	private int tokens;
	
	/*
	 * Description : creates a Place with 0 tokens.
	 */
	public Place() {
		this(0);
	}
	
	/*
	 * Description : creates a Place with tok tokens.
	 */
	public Place (int tok){
		this.tokens = Math.abs(tok);		
		super.arcInList = new ArrayList<ArcIn>();
		super.arcOutList = new ArrayList<ArcOut>();
	}
	
	/*
	 * Description : returns the number of tokens from this place.
	 */
	public int getTokens() {
		return tokens;
	}

	
	/*
	 * Description : add addedTokens to this Place.
	 */
	public void addTokens(int addedTokens) {
		this.tokens = Math.max(0, this.tokens + addedTokens);
	}
	
	/*
	 * Description : remove removedTokens to this Place.
	 */
	public void removeTokens(int removedTokens) {
		this.tokens = Math.max(0, this.tokens - removedTokens);
	}
}

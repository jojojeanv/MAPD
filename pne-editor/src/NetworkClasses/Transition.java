package NetworkClasses;

import java.util.ArrayList;

public class Transition extends Location {
	
	/*
	 * Description : create an empty Transition.
	 */
	public Transition() {
		super.arcInList = new ArrayList<ArcIn>();
		super.arcOutList = new ArrayList<ArcOut>();
	}
	
	/*
	 * Description : returns true if the Transition is pullable, false otherwise.
	 */
	public boolean pullAble() {		
		for (ArcOut arc : this.arcOutList) {
			if (arc.getIsZero()) {
				if (arc.getOrigin().getTokens() > 0) {
					return false;
				}
			}
			
			else if (arc.getIsEmpty()) {
				if (arc.getOrigin().getTokens() == 0) {
					return false;
				}
			}
			
			else if (arc.getWeight() > arc.getOrigin().getTokens()) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Description : Does a pull from the selected Transition.
	 */
	public void pull() {
		if (this.pullAble()) {
			for (ArcOut arc : this.arcOutList) {			
				if (arc.getIsEmpty()) {
					arc.getOrigin().removeTokens(arc.getOrigin().getTokens());
				}	
				
				else {
					arc.getOrigin().removeTokens(arc.getWeight());
				}
			}	
			
			for (ArcIn arc : this.arcInList) {
				arc.getDestination().addTokens(arc.getWeight());
			}
		}
	}
}

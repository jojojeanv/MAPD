package NetworkClasses;

import java.util.ArrayList;

public class Location {
	
	protected ArrayList <ArcIn> arcInList;
	protected ArrayList <ArcOut> arcOutList;
	
	/*
	 * Description : returns this location's arcInList.
	 */
	public ArrayList <ArcIn> getArcIn() {
		return this.arcInList;
	}
	
	/*
	 * Description : returns this location's arcOutList.
	 */
	public ArrayList <ArcOut> getArcOut() {
		return this.arcOutList;
	}
	
	/*
	 * Description : add an ArcIn to this location's arcInList
	 */
	public void addArcIn(ArcIn arc) {
		this.arcInList.add(arc);
	}
	
	/*
	 * Description : add an ArcOut to this location's arcOutList
	 */
	public void addArcOut(ArcOut arc) {
		this.arcOutList.add(arc);
	}
	
	/*
	 * Description : remove an ArcIn from this location's arcInList
	 */
	public void removeArcIn(ArcIn arc) {
		if (this.arcInList.contains(arc)) {
			int n = this.arcInList.indexOf(arc);
			this.arcInList.remove(n);
		}
	}
	
	/*
	 * Description : remove an ArcOut from this location's arcOutList
	 */
	public void removeArcOut(ArcOut arc) {
		if (this.arcOutList.contains(arc)) {
			int n = this.arcOutList.indexOf(arc);
			this.arcOutList.remove(n);
		}
	}
}

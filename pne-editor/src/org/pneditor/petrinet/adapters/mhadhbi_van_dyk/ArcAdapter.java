package org.pneditor.petrinet.adapters.mhadhbi_van_dyk;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import NetworkClasses.*;


public class ArcAdapter extends AbstractArc {
	
	private ArcIn arcIn;
	private ArcOut arcOut;
	
	@Override
	public AbstractNode getSource() {
		if (this.isRegular()) {
			Transition origin = arcIn.getOrigin();
			return TransitionAdapter(origin);
		}
		else {
			Place origin = arcOut.getOrigin();
			return PlaceAdapter(origin);
		}
	}

	@Override
	public AbstractNode getDestination() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isReset() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRegular() {
		return false;
	}

	@Override
	public boolean isInhibitory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		
	}

}

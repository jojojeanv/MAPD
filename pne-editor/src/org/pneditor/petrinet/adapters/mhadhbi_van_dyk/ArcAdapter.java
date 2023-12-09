package org.pneditor.petrinet.adapters.mhadhbi_van_dyk;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;

import Exception.InexistentPlaceException;
import NetworkClasses.*;


public class ArcAdapter extends AbstractArc {
	
	private AbstractNode source;
	private AbstractNode destination;
	private Arc concreteArc;
	
	private boolean isInhibitory = false;
	private boolean isReset = false;
	private boolean isRegular = true;
	
	public ArcAdapter(AbstractNode source, AbstractNode destination) {
		this.source = source;
		this.destination = destination;
	}
	
	@Override
	public AbstractNode getSource() {
		return source;
	}

	@Override
	public AbstractNode getDestination() {
		return destination;
	}

	@Override
	public boolean isReset() {
		return isReset;
	}

	@Override
	public boolean isRegular() {
		return isRegular;
	}

	@Override
	public boolean isInhibitory() {
		return isInhibitory;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		return this.concreteArc.getWeight();
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		this.concreteArc.setWeight(multiplicity);
	}
	
	public Arc getConcreteArc() {
		return concreteArc;
	}
	
	public void setConcreteArc(Arc arc) {
		this.concreteArc = arc;
	}
	
	public void setReset() {
		this.isRegular = false;
		this.isReset = true;
	}
	
	public void setInhibitory() {
		this.isInhibitory = true;
		this.isRegular = false;
	}

}

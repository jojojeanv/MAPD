package org.pneditor.petrinet.adapters.mhadhbi_van_dyk;

import java.util.HashMap;

import org.pneditor.petrinet.AbstractTransition;

import NetworkClasses.Transition;

public class TransitionAdapter extends AbstractTransition{
	
	private static int NEXT;
	private Transition tr;
	
	public TransitionAdapter() {
		super("T_" + NEXT);
		this.setId(NEXT);
		this.tr = new Transition();
		NEXT++;
	}
	
	public Transition getConcreteTransition() {
		return this.tr;
	}
	
}

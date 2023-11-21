package org.pneditor.petrinet.adapters.mhadhbi_van_dyk;

import java.util.HashMap;

import org.pneditor.petrinet.AbstractTransition;

import NetworkClasses.Transition;

public class TransitionAdapter extends AbstractTransition{
	
	private static HashMap<Integer, Transition> reference = new HashMap<Integer, Transition>();
	private static int NEXT;
	
	public TransitionAdapter(String label) {
		super(label);
		this.setId(NEXT);
		Transition tr = new Transition();
		reference.put(NEXT,tr);
		NEXT++;
		
	}

}

package org.pneditor.petrinet.adapters.mhadhbi_van_dyk;

import org.pneditor.petrinet.AbstractPlace;

import NetworkClasses.Place;

import java.util.HashMap;

public class PlacesAdapter extends AbstractPlace {
	
	private static HashMap<Integer, Place> reference = new HashMap<Integer, Place>();
	private static int NEXT;

	public PlacesAdapter(String label) {
		super(label);
		this.setId(NEXT);
		Place p = new Place();
		reference.put(NEXT, p);	
		NEXT++;
	}

	@Override
	public void addToken() {
		Place p = reference.get(this.getId());
		p.addTokens(1);
	}

	@Override
	public void removeToken() {
		Place p = reference.get(this.getId());
		p.removeTokens(1);
	}

	@Override
	public int getTokens() {
		Place p = reference.get(this.getId());	
		return p.getTokens();
	}

	@Override
	public void setTokens(int tokens) {
		Place p = reference.get(this.getId());
		p.addTokens(tokens-p.getTokens());
	}

}

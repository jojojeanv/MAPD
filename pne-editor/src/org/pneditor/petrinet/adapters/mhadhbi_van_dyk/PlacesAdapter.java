package org.pneditor.petrinet.adapters.mhadhbi_van_dyk;

import org.pneditor.petrinet.AbstractPlace;

import NetworkClasses.Place;

import java.util.HashMap;

public class PlacesAdapter extends AbstractPlace {
	
	private Place p = new Place();
	private static int NEXT;

	public PlacesAdapter() {
		super("P_" + NEXT);
		this.setId(NEXT);
		NEXT++;
	}

	@Override
	public void addToken() {
		p.addTokens(1);
	}

	@Override
	public void removeToken() {
		p.removeTokens(1);
	}

	@Override
	public int getTokens() {
		return p.getTokens();
	}

	@Override
	public void setTokens(int tokens) {
		p.addTokens(tokens-p.getTokens());
	}
	
	public Place getConcretePlace() {
		return p;
	}

}

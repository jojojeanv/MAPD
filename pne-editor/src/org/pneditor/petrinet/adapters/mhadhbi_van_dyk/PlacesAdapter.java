package org.pneditor.petrinet.adapters.mhadhbi_van_dyk;

import org.pneditor.petrinet.AbstractPlace;
import java.util.HashMap;

public class PlacesAdapter extends AbstractPlace {
	
	private static int NEXT;
	private static HashMap<String, int> reference = new HashMap<String, int>();

	public PlacesAdapter(String label) {
		super(label);
		
	}

	@Override
	public void addToken() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeToken() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTokens() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTokens(int tokens) {
		// TODO Auto-generated method stub
		
	}

}

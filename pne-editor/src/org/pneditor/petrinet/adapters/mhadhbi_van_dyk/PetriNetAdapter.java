package org.pneditor.petrinet.adapters.mhadhbi_van_dyk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.adapters.mhadhbi_van_dyk.*;

import Exception.InexistentArcInException;
import Exception.InexistentArcOutException;
import Exception.InexistentPlaceException;
import Exception.InexistentTransitionException;

import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import NetworkClasses.*;

public class PetriNetAdapter extends PetriNetInterface {
	
	private PetriNetwork pn = new PetriNetwork();
	private final Set<AbstractPlace> places = new HashSet<>();
	private final Set<AbstractTransition> transitions = new HashSet<>();
	private final Set<AbstractArc> arcs = new HashSet<>();
	
	/*
	 * Built PlacesAdapter and concrete Place
	 * Then put both of them in their respective petriNet
	 */
	@Override
	public AbstractPlace addPlace() {
		PlacesAdapter p0 = new PlacesAdapter();
		places.add(p0);
		pn.addPlace(p0.getConcretePlace());
		return p0;
		}
	
	/*
	 * Built PlacesAdapter and concrete Place
	 * Then put both of them in their respective petriNet
	 */
	@Override
	public AbstractTransition addTransition() {
		TransitionAdapter t0 = new TransitionAdapter();
		transitions.add(t0);
		pn.addTransition(t0.getConcreteTransition());
		return t0;
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) 
			throws UnimplementedCaseException{
		
		ArcAdapter abstractArc = new ArcAdapter(source, destination);
		arcs.add(abstractArc);
		
		if (source.isPlace()) {
			try {
				ArcOut concreteArc = new ArcOut(((PlacesAdapter)source).getConcretePlace(), ((TransitionAdapter)destination).getConcreteTransition(), 1);
				abstractArc.setConcreteArc(concreteArc);
				pn.addArcOut(concreteArc);
			} catch (InexistentPlaceException e) {
				e.printStackTrace();
			}
		}
		
		else {
			try {
				ArcIn concreteArc = new ArcIn(((TransitionAdapter)source).getConcreteTransition(), ((PlacesAdapter)destination).getConcretePlace(), 1);
				abstractArc.setConcreteArc(concreteArc);
				pn.addArcIn(concreteArc);
			} catch (InexistentPlaceException e) {
				e.printStackTrace();
			}
		}
		
		return abstractArc;
	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		
		ArcAdapter abstractArc = new ArcAdapter(place, transition);
		ZeroArc concreteArc = new ZeroArc(((PlacesAdapter) place).getConcretePlace(), ((TransitionAdapter) transition).getConcreteTransition(), 0);
		
		arcs.add(abstractArc);
		abstractArc.setConcreteArc(concreteArc);
		abstractArc.setInhibitory();
		
		try {
			pn.addArcOut(concreteArc);
		} catch (InexistentPlaceException e) {
			e.printStackTrace();
		}
		return abstractArc;
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		
		ArcAdapter abstractArc = new ArcAdapter(place, transition);
		EmptyArc concreteArc = new EmptyArc(((PlacesAdapter) place).getConcretePlace(), ((TransitionAdapter) transition).getConcreteTransition(), 0);
		
		arcs.add(abstractArc);
		abstractArc.setConcreteArc(concreteArc);
		abstractArc.setReset();
		
		try {
			pn.addArcOut(concreteArc);
		} catch (InexistentPlaceException e) {
			e.printStackTrace();
		}
		return abstractArc;
	}

	@Override
	public void removePlace(AbstractPlace place) {
		
		if (places.contains(place)) {
			Place concretePlace = ((PlacesAdapter)place).getConcretePlace();
			places.remove(place);
			try {
				pn.removePlace(concretePlace);
			} catch (InexistentPlaceException e) {
				e.printStackTrace();
			} catch (InexistentArcOutException e) {
				e.printStackTrace();
			} catch (InexistentArcInException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		
		if (transitions.contains(transition)) {
			Transition concreteTransition = ((TransitionAdapter)transition).getConcreteTransition();
			transitions.remove(transition);
			try {
				pn.removeTransition(concreteTransition);
			} catch (InexistentTransitionException e) {
				e.printStackTrace();
			} catch (InexistentArcInException e) {
				e.printStackTrace();
			} catch (InexistentArcOutException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void removeArc(AbstractArc arc) {
		
		if (arcs.contains(arc)) {
			Arc concreteArc = ((ArcAdapter)arc).getConcreteArc();
			arcs.remove(arc);
			if (concreteArc.isIn()) {
				try {
					pn.removeArcIn((ArcIn)concreteArc);
					System.out.print("dest ArcIn \n");
				} catch (InexistentArcInException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					pn.removeArcOut((ArcOut)concreteArc);
					System.out.print("dest ArcOut \n");
				} catch (InexistentArcOutException e) {
					e.printStackTrace();
				} 
			}
		}
		
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		return ((TransitionAdapter)transition).getConcreteTransition().pullAble();
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		((TransitionAdapter)transition).getConcreteTransition().pull();
	}

}

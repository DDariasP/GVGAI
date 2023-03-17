package si2023.diegodarias741.p04.states;

import java.util.LinkedList;

import si2023.diegodarias741.p04.actions.*;
import si2023.diegodarias741.p04.fsm.*;

public abstract class State {

	protected String name;
	protected IAction action;
	protected LinkedList<Transition> transitionList;

	public void setList(LinkedList<Transition> t) {
		transitionList = t;
	}

	public LinkedList<Transition> getTransitions() {
		return transitionList;
	}

	public IAction getAction() {
		return action;
	}

}

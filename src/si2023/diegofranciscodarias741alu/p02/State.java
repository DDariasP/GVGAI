package si2023.diegofranciscodarias741alu.p02;

import java.util.LinkedList;


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

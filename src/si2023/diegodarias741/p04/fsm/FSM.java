package si2023.diegodarias741.p04.fsm;

import java.util.LinkedList;

import si2023.diegodarias741.p04.states.*;

public abstract class FSM implements IBrain {

	protected State initialState;
	protected State currentState;

	public State trigger(World89 w) {

		Transition triggeredTransition = null;
		LinkedList<Transition> list = currentState.getTransitions();
		Transition t;
		Boolean flag = false;
		int i = 0;
		
		if (list != null) {
			while (i < list.size() && !flag) {
				t = list.get(i);
				i++;
				if (t.isTriggered(w)) {
					triggeredTransition = t;
					flag = true;
				}
			}
		}
		
		if (triggeredTransition != null) {
			currentState = triggeredTransition.getTargetState();
		}

		return currentState;
	}

}

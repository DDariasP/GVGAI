package si2023.diegodarias741.p04.fsm;

import si2023.diegodarias741.p04.conditions.*;
import si2023.diegodarias741.p04.states.*;

public class Transition {
	
	private ICondition condition;
	private State goalState;
	
	public Transition(ICondition c,State gs) {
		
		condition = c;
		goalState = gs;
	}

	public boolean isTriggered(World89 w) {
		
		return condition.isTrue(w);
	}

	public State getTargetState() {
		
		return goalState;
	}

}

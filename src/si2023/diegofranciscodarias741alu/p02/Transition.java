package si2023.diegofranciscodarias741alu.p02;


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

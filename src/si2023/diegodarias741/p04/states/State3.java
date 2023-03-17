package si2023.diegodarias741.p04.states;

import si2023.diegodarias741.p04.actions.*;

public class State3 extends State {
	
	public State3() {
		
		name = "fallingPerson";
		action = new SavePerson();
		
	}
	
}
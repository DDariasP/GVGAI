package si2023.diegodarias741.p04.states;

import si2023.diegodarias741.p04.actions.*;

public class State1 extends State {
	
	public State1() {
		
		name = "bottomRow";
		action = new LeaveSpawn();
		
	}

}

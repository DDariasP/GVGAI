package si2023.diegodarias741.p04.states;

import si2023.diegodarias741.p04.actions.*;

public class State2 extends State {
	
	public State2() {
		
		name = "fullBag";
		action = new EmptyBag();
		
	}
	
}
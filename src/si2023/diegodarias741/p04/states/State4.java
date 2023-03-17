package si2023.diegodarias741.p04.states;

import si2023.diegodarias741.p04.actions.*;

public class State4 extends State {
	
	public State4() {
		
		name = "foundVillain";
		action = new CaptureVillain();
		
	}
	
}
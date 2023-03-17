package si2023.diegodarias741.p04.actions;

import ontology.Types.ACTIONS;
import si2023.diegodarias741.p04.fsm.*;

public class LeaveSpawn implements IAction {

	@Override
	public ACTIONS doAction(World89 w) {
		
		return ACTIONS.ACTION_UP;
	}

}

package si2023.diegodarias741.actions;

import ontology.Types.ACTIONS;
import si2023.diegodarias741.agent.*;
import si2023.diegodarias741.engine.*;

public class LeaveSpawn implements IAction {

	@Override
	public ACTIONS doAction(World w) {
		
		return ACTIONS.ACTION_UP;
	}

}

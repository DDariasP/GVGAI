package si2023.diegodarias741.actions;

import ontology.Types.ACTIONS;
import si2023.diegodarias741.agent.World;
import si2023.diegodarias741.engine.IAction;

public class StayIdle implements IAction {

	@Override
	public ACTIONS doAction(World w) {
		
		return ACTIONS.ACTION_NIL;
	}

}

package si2023.diegodarias741.p03.actions;

import ontology.Types.ACTIONS;
import si2023.diegodarias741.p03.agent.*;
import si2023.diegodarias741.p03.engine.*;

public class StayIdle implements IAction {

	@Override
	public ACTIONS doAction(World w) {
		
		return ACTIONS.ACTION_NIL;
	}

}

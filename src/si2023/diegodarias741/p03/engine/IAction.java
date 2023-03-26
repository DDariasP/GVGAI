package si2023.diegodarias741.p03.engine;

import ontology.Types.ACTIONS;
import si2023.diegodarias741.p03.agent.*;

public interface IAction {
	
	public ACTIONS doAction(World w);

}

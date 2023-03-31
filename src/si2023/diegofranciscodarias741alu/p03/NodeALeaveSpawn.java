package si2023.diegofranciscodarias741alu.p03;

import ontology.Types.ACTIONS;

public class NodeALeaveSpawn extends TreeNodeAction {

	public NodeALeaveSpawn(String n) {
		super(n);
	}

	@Override
	public ACTIONS doAction(AgentWorld89 w) {
				
		return ACTIONS.ACTION_UP;
	}

}

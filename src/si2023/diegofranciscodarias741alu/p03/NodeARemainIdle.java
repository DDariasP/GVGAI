package si2023.diegofranciscodarias741alu.p03;

import ontology.Types.ACTIONS;

public class NodeARemainIdle extends TreeNodeAction {

	public NodeARemainIdle(String n) {
		super(n);
	}

	@Override
	public ACTIONS doAction(AgentWorld89 w) {
				
		return ACTIONS.ACTION_NIL;
	}

}

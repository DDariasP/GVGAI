package si2023.diegodarias741.p05;

import ontology.Types.ACTIONS;

public abstract class TreeNodeAction extends TreeNode {
	
	public TreeNodeAction(String n) {
		super(n);
	}

	public abstract ACTIONS doAction(AgentWorld89 w);
	
	@Override
	public TreeNode decide(AgentWorld89 w) {

		return this;
	}

}

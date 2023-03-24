package si2023.diegodarias741.p05;

import ontology.Types.ACTIONS;

public abstract class Tree implements IBrain {

	protected TreeNode root;

	public ACTIONS think(AgentWorld89 w) {

		//System.out.println(root.label);
		
		TreeNodeAction n = ((TreeNodeAction)root.decide(w));
		
		return n.doAction(w);

	}

}

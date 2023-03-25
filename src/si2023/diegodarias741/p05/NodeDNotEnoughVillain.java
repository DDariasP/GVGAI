package si2023.diegodarias741.p05;

public class NodeDNotEnoughVillain extends TreeNodeDecision {

	public NodeDNotEnoughVillain (String n) {
		super(n);
	}

	@Override
	public TreeNode getBranch(AgentWorld89 w) {
				
		ICondition c = new CVillainLTX();

		Boolean flag = c.isTrue(w);

		if (flag) {
			return yesNode;
		} else {
			return noNode;
		}
	}

}
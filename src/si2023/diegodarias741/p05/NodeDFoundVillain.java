package si2023.diegodarias741.p05;

public class NodeDFoundVillain extends TreeNodeDecision {

	public NodeDFoundVillain (String n) {
		super(n);
	}

	@Override
	public TreeNode getBranch(AgentWorld89 w) {
				
		ICondition c = new CFoundVillain();

		Boolean flag = c.isTrue(w);

		if (flag) {
			return yesNode;
		} else {
			return noNode;
		}
	}

}
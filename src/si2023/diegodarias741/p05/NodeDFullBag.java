package si2023.diegodarias741.p05;

public class NodeDFullBag extends TreeNodeDecision {

	public NodeDFullBag (String n) {
		super(n);
	}

	@Override
	public TreeNode getBranch(AgentWorld89 w) {
		
		ICondition c = new CFullBag();

		Boolean flag = c.isTrue(w);

		if (flag) {
			return yesNode;
		} else {
			return noNode;
		}
	}

}
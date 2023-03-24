package si2023.diegodarias741.p05;

public class NodeDFallingPerson extends TreeNodeDecision {

	public NodeDFallingPerson (String n) {
		super(n);
	}

	@Override
	public TreeNode getBranch(AgentWorld89 w) {
		
		ICondition c = new CFallingPerson();

		Boolean flag = c.isTrue(w);

		if (flag) {
			return yesNode;
		} else {
			return noNode;
		}
	}

}
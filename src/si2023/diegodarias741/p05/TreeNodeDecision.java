package si2023.diegodarias741.p05;

public abstract class TreeNodeDecision extends TreeNode {

	public TreeNodeDecision(String n) {
		super(n);
	}

	public abstract TreeNode getBranch(AgentWorld89 w);

	@Override
	public TreeNode decide(AgentWorld89 w) {

		return this.getBranch(w);
	}

}

package si2023.diegofranciscodarias741alu.p03;

public abstract class TreeNode {

	protected TreeNode yesNode;
	protected TreeNode noNode;
	public String label;

	public TreeNode(String n) {
		label = n;
	}

	public void setYes(TreeNode yes) {
		yesNode = yes;
	}

	public void setNo(TreeNode no) {
		noNode = no;
	}

	public abstract TreeNode decide(AgentWorld89 w);

}

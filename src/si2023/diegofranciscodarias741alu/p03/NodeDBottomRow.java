package si2023.diegofranciscodarias741alu.p03;

public class NodeDBottomRow extends TreeNodeDecision {

	public NodeDBottomRow(String n) {
		super(n);
	}

	@Override
	public TreeNode getBranch(AgentWorld89 w) {
				
		ICondition c = new CBottomRow();

		Boolean flag = c.isTrue(w);
		
		if (flag) {
			return yesNode;
		} else {
			return noNode;
		}
	}

}

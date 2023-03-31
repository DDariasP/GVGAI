package si2023.diegofranciscodarias741alu.p03;

public class NodeDNotEveryoneSafe extends TreeNodeDecision {

	public NodeDNotEveryoneSafe(String n) {
		super(n);
	}

	@Override
	public TreeNode getBranch(AgentWorld89 w) {
				
		ICondition c = new CNotEveryoneSafe();

		Boolean flag = c.isTrue(w);
		
		if (flag) {
			return yesNode;
		} else {
			return noNode;
		}
	}

}

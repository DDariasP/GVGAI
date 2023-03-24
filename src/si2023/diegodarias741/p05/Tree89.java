package si2023.diegodarias741.p05;

public class Tree89 extends Tree {

	public Tree89() {

		root = new NodeDBottomRow("A");

		TreeNode nodeB = new NodeALeaveSpawn("B");
		TreeNode nodeC = new NodeACaptureVillain("C");

		root.setYes(nodeB);
		
		root.setNo(nodeC);

	}

}

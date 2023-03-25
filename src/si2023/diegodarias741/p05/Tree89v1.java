package si2023.diegodarias741.p05;

public class Tree89v1 extends Tree {

	public Tree89v1() {

		root = new NodeDBottomRow("A");
		TreeNode nodeB = new NodeALeaveSpawn("B");
		TreeNode nodeC = new NodeDFallingPerson("C");
		TreeNode nodeD = new NodeASavePerson("D");
		TreeNode nodeE = new NodeDFullBag("E");
		TreeNode nodeF = new NodeAEmptyBag("F");
		TreeNode nodeG = new NodeDFoundVillain("G");
		TreeNode nodeH = new NodeACaptureVillain("H");
		TreeNode nodeI = new NodeAEmptyBag("I");

		root.setYes(nodeB);
		root.setNo(nodeC);
		
		nodeC.setYes(nodeD);
		nodeC.setNo(nodeE);
		
		nodeE.setYes(nodeF);
		nodeE.setNo(nodeG);
		
		nodeG.setYes(nodeH);
		nodeG.setNo(nodeI);

	}

}

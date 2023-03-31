package si2023.diegofranciscodarias741alu.p03;

public class Tree89v2 extends Tree {

	public Tree89v2() {
		
		root = new NodeDBottomRow("A");
		TreeNode nodeB = new NodeALeaveSpawn("B");
		TreeNode nodeC = new NodeDFallingPerson("C");
		TreeNode nodeD = new NodeASavePerson("D");
		TreeNode nodeE = new NodeDFullBag("E");
		TreeNode nodeF = new NodeAEmptyBag("F");
		TreeNode nodeG = new NodeDNotEveryoneSafe("G");
		TreeNode nodeH = new NodeARemainIdle("H");
		TreeNode nodeI = new NodeDFoundVillain("I");
		TreeNode nodeJ = new NodeACaptureVillain("J");
		TreeNode nodeK = new NodeARemainIdle("K");

		root.setYes(nodeB);
		root.setNo(nodeC);
		
		nodeC.setYes(nodeD);
		nodeC.setNo(nodeE);
		
		nodeE.setYes(nodeF);
		nodeE.setNo(nodeG);
		
		nodeG.setYes(nodeH);
		nodeG.setNo(nodeI);
		
		nodeI.setYes(nodeJ);
		nodeI.setNo(nodeK);

	}

}

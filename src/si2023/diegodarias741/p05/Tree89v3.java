package si2023.diegodarias741.p05;

public class Tree89v3 extends Tree {

	public Tree89v3() {
		
		root = new NodeDBottomRow("A");
		TreeNode nodeB = new NodeALeaveSpawn("B");
		TreeNode nodeC = new NodeDFallingPerson("C");
		TreeNode nodeD = new NodeASavePerson("D");
		TreeNode nodeE = new NodeDFullBag("E");
		TreeNode nodeF = new NodeAEmptyBag("F");
		TreeNode nodeG = new NodeDNotEveryoneSafe("G");
		TreeNode nodeH = new NodeDNotEnoughVillain("H");
		TreeNode nodeI = new NodeDFoundVillain("I");
		TreeNode nodeJ = new NodeAGoMiddle("J");
		TreeNode nodeK = new NodeDFoundVillain("K");
		TreeNode nodeL = new NodeACaptureVillain("L");
		TreeNode nodeM = new NodeARemainIdle("M");
		TreeNode nodeN = new NodeACaptureVillain("N");
		TreeNode nodeO = new NodeARemainIdle("O");

		root.setYes(nodeB);
		root.setNo(nodeC);
		
		nodeC.setYes(nodeD);
		nodeC.setNo(nodeE);
		
		nodeE.setYes(nodeF);
		nodeE.setNo(nodeG);
		
		nodeG.setYes(nodeH);
		nodeG.setNo(nodeI);
		
		nodeH.setYes(nodeJ);
		nodeH.setNo(nodeK);
		
		nodeI.setYes(nodeL);
		nodeI.setNo(nodeM);
		
		nodeK.setYes(nodeN);
		nodeK.setNo(nodeO);

	}

}

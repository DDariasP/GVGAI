package si2023.diegofranciscodarias741alu.p04;

import ontology.Types.ACTIONS;

public interface IState {

	public INode getNodeAvatar();

	public INode getNodeGoal();

	public ACTIONS doTransition(INode current, INode next);

}

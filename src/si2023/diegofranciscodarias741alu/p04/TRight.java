package si2023.diegofranciscodarias741alu.p04;

import ontology.Types.ACTIONS;

public class TRight extends Transition {

	public TRight() {
		name = "right";
	}

	@Override
	public ACTIONS getAction() {
		return ACTIONS.ACTION_RIGHT;
	}

}

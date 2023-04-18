package si2023.diegofranciscodarias741alu.p04;

import ontology.Types.ACTIONS;

public class TUp extends Transition {

	public TUp() {
		name = "up";
	}

	@Override
	public ACTIONS getAction() {
		return ACTIONS.ACTION_UP;
	}

}

package si2023.diegofranciscodarias741alu.p04;

import ontology.Types.ACTIONS;

public class TDown extends Transition {

	public TDown() {
		name = "down";
	}

	@Override
	public ACTIONS getAction() {
		return ACTIONS.ACTION_DOWN;
	}

}

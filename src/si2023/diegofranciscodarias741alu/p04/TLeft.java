package si2023.diegofranciscodarias741alu.p04;

import ontology.Types.ACTIONS;

public class TLeft extends Transition {

	public TLeft() {
		name = "left";
	}

	@Override
	public ACTIONS getAction() {
		return ACTIONS.ACTION_LEFT;
	}

}

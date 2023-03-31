package si2023.diegofranciscodarias741alu.p01;


import ontology.Types.ACTIONS;


public class LeaveSpawn implements IAction {

	@Override
	public ACTIONS doAction(World w) {
		
		return ACTIONS.ACTION_UP;
	}

}

package si2023.diegofranciscodarias741alu.p00;

import core.game.StateObservation;
import ontology.Types.ACTIONS;



public class Brain implements IBrain {

	private AgentWorld50 w;

	public Brain() {



	}

	public void scanWorld(StateObservation so) {

		w = new AgentWorld50(so);
		w.readMap();
		w.printMap();

	}

	@Override
	public ACTIONS think(AgentWorld50 w) {
		// TODO Auto-generated method stub
		return ACTIONS.ACTION_NIL;
	}

}
package si2023.diegodarias741.agent;

import core.game.StateObservation;
import ontology.Types.ACTIONS;
import si2023.diegodarias741.engine.*;

public class Brain {

	private World w;

	public Brain(StateObservation stateObs) {

		w = new World(stateObs);
	}

	public void scanWorld(StateObservation so) {

		w = new World(so);
		w.readMap();

	}

	public ACTIONS think(Engine e) {
		
		Rule r = e.trigger(w);

		if (r != null) {
			
			return r.getAction().doAction(w);
			
		} else {
			
			return ACTIONS.ACTION_NIL;
		}

	}

}

package si2023.diegodarias741.p03.agent;

import core.game.StateObservation;
import ontology.Types.ACTIONS;

public interface IBrain {

	public void scanWorld(StateObservation so);

	public ACTIONS think();

}

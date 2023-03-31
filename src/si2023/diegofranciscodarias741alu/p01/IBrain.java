package si2023.diegofranciscodarias741alu.p01;


import core.game.StateObservation;
import ontology.Types.ACTIONS;

public interface IBrain {

	public void scanWorld(StateObservation so);

	public ACTIONS think();

}

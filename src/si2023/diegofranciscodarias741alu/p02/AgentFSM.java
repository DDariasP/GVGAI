/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package si2023.diegofranciscodarias741alu.p02;

import core.game.StateObservation;
import core.player.AbstractPlayer;
import ontology.Types.ACTIONS;
import tools.ElapsedCpuTimer;

/**
 *
 * @author Diego
 */
public class AgentFSM extends AbstractPlayer {
	
	private IBrain brain;
	private World89 world89;

	public AgentFSM(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {
		
		//new brain & new world89
		brain = new FSM89();
		world89 = new World89(stateObs);
	}

	@Override
	public ACTIONS act(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {

		world89.scanWorld(stateObs);
		//world89.printMap();
		State s = brain.trigger(world89);
		ACTIONS a = s.getAction().doAction(world89);
		//System.out.println(a);
		return a;
	}
}
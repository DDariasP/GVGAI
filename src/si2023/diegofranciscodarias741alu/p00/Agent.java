/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package si2023.diegofranciscodarias741alu.p00;

import core.game.StateObservation;
import core.player.AbstractPlayer;
import ontology.Types.ACTIONS;
import tools.ElapsedCpuTimer;

/**
 *
 * @author Diego
 */
public class Agent extends AbstractPlayer {

	private IBrain brain;
	private AgentWorld50 world;

	public Agent(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {

		//new brain & new agentWorld89
		brain = new Brain();
		world = new AgentWorld50(stateObs);
	}

	@Override
	public ACTIONS act(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {

		world.scanWorld(stateObs);
		world.printMap();
		ACTIONS a = brain.think(world);
		//System.out.println(a);
		return a;
	}
}
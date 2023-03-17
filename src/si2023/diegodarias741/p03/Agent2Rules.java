/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package si2023.diegodarias741.p03;

import core.game.StateObservation;
import core.player.AbstractPlayer;
import ontology.Types.ACTIONS;
import si2023.diegodarias741.p03.agent.*;
import si2023.diegodarias741.p03.engine.*;
import tools.ElapsedCpuTimer;

/**
 *
 * @author Diego
 */
public class Agent2Rules extends AbstractPlayer {

	//agent
	private IBrain brain;

	public Agent2Rules(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {
		
		//new brain
		brain = new Engine();
	}

	@Override
	public ACTIONS act(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {

		brain.scanWorld(stateObs);
		ACTIONS a = brain.think();
		//System.out.println(a);
		return a;
	}
}
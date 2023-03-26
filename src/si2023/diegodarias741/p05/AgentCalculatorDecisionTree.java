/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package si2023.diegodarias741.p05;

import core.game.StateObservation;
import core.player.AbstractPlayer;
import ontology.Types.ACTIONS;
import tools.ElapsedCpuTimer;

/**
 *
 * @author Diego
 */
public class AgentCalculatorDecisionTree extends AbstractPlayer {

	private IBrain brain;
	private AgentWorld89 agentWorld89;

	public AgentCalculatorDecisionTree(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {

		//new brain & new agentWorld89
		brain = new Tree89v3();
		agentWorld89 = new AgentWorld89(stateObs);
	}

	@Override
	public ACTIONS act(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {

		agentWorld89.scanWorld(stateObs);
		//agentWorld89.printMap();
		ACTIONS a = brain.think(agentWorld89);
		//System.out.println(a);
		return a;
	}
}
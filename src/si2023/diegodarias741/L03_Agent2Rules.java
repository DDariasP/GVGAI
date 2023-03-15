/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package si2023.diegodarias741;

import java.util.ArrayList;

import core.game.StateObservation;
import core.player.AbstractPlayer;
import ontology.Types.ACTIONS;
import si2023.diegodarias741.actions.*;
import si2023.diegodarias741.agent.*;
import si2023.diegodarias741.conditions.*;
import si2023.diegodarias741.engine.*;
import tools.ElapsedCpuTimer;

/**
 *
 * @author Diego
 */
public class L03_Agent2Rules extends AbstractPlayer {

	//agent
	private Brain brain;
	private Engine engine;

	public L03_Agent2Rules(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {
		
		//conditions
		ICondition cond0 = new BottomRow();
		ICondition cond1 = new FallingPerson();
		ICondition cond2 = new FullBag();
		ICondition cond3 = new FoundVillain();
		
		//condition lists
		ArrayList<ICondition> listBottom = new ArrayList<ICondition>();
		listBottom.add(cond0);
		ArrayList<ICondition> listFalling = new ArrayList<ICondition>();
		listFalling.add(cond1);
		ArrayList<ICondition> listFull = new ArrayList<ICondition>();
		listFull.add(cond2);
		ArrayList<ICondition> listFound = new ArrayList<ICondition>();
		listFound.add(cond3);
		
		//actions
		IAction acBottom = new LeaveSpawn();
		IAction acFalling = new SavePerson();
		IAction acFull = new EmptyBag();
		IAction acFound = new CaptureVillain();
		
		//rules
		Rule rBottom = new Rule(listBottom,acBottom,"rBottom");
		Rule rFalling = new Rule(listFalling,acFalling,"rFalling");
		Rule rFull = new Rule(listFull,acFull,"rFull");
		Rule rFound = new Rule(listFound,acFound,"rFound");
		
		//rule list
		ArrayList<Rule> rules = new ArrayList<Rule>();
		rules.add(rBottom);
		rules.add(rFalling);
		rules.add(rFull);
		rules.add(rFound);

		//new brain & new engine
		brain = new Brain(stateObs);
		engine = new Engine(rules);
	}

	@Override
	public ACTIONS act(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {

		brain.scanWorld(stateObs);
		ACTIONS a = brain.think(engine);
		System.out.println(a);
		return a;
	}
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package si2023.diegodarias741;

import java.util.Random;

import core.game.StateObservation;
import core.player.AbstractPlayer;
import ontology.Types;
import ontology.Types.ACTIONS;
import si2023.diegodarias741.agent.*;
import tools.ElapsedCpuTimer;

/**
 *
 * @author Diego
 */
public class L03_Agent1Print extends AbstractPlayer {

	private Random r = new Random(System.currentTimeMillis());
	private int n;
	private ACTIONS a;

	public L03_Agent1Print(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {
	}

	@Override
	public ACTIONS act(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {

		World w = new World(stateObs);
		w.readMap();
		w.printMap();

		n = r.nextInt(100) % 4;
		switch (n) {
		case 0:
			a = Types.ACTIONS.ACTION_RIGHT;
			break;
		case 1:
			a = Types.ACTIONS.ACTION_LEFT;
			break;
		case 2:
			a = Types.ACTIONS.ACTION_UP;
			break;
		case 3:
			a = Types.ACTIONS.ACTION_DOWN;
			break;
		default:
			a = Types.ACTIONS.ACTION_NIL;
			break;
		}

		return a;
	}
}

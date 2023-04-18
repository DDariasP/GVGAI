/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package si2023.diegofranciscodarias741alu.p04;

import java.util.LinkedList;

import core.game.StateObservation;
import core.player.AbstractPlayer;
import ontology.Types.ACTIONS;
import tools.ElapsedCpuTimer;

/**
 *
 * @author Diego
 */
public class Agent50AStar extends AbstractPlayer {

	private IBrain brain;
	private IState world;
	private INode current;
	private LinkedList<INode> path;
	int count;

	public Agent50AStar(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {

		//new brain & path
		brain = new AStar();
		path = new LinkedList<INode>();
		count = 0;
	}

	@Override
	public ACTIONS act(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {

		//wait until items load
		if (count == 1) {
			world = new State50(stateObs);
			path = brain.findPath(world);
			if (path != null) {
				current = (Node50) path.pollFirst();
			}
		}

		//move
		if (count > 1) {
			if (path.size() > 0) {
				System.out.println(path.size() + " to go");
				Node50 next = (Node50) path.pollFirst();
				//System.out.println("current\n" + current);
				//System.out.println("cost = " + current.costFunction() + " = " + current.getTraversed() + " + " + current.getHeuristic());
				System.out.println("next\n" + next);
				//System.out.println("cost = " + next.costFunction() + " = " + next.getTraversed() + " + " + next.getHeuristic());*/
				ACTIONS a = brain.think(current, next);
				current = next;
				//System.out.println(a);
				return a;
			}
		}

		count++;
		return ACTIONS.ACTION_NIL;
	}
}
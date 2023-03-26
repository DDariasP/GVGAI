package si2023.diegodarias741.p03.engine;

import java.util.ArrayList;

import core.game.StateObservation;
import ontology.Types.ACTIONS;
import si2023.diegodarias741.p03.actions.*;
import si2023.diegodarias741.p03.agent.*;
import si2023.diegodarias741.p03.conditions.*;


public class Engine implements IBrain {

	private World w;
	private ArrayList<Rule> rules;

	public Engine() {

		//conditions
		ICondition cond0 = new BottomRow();
		ICondition cond1 = new FallingPerson();
		ICondition cond2 = new FullBag();
		ICondition cond3 = new FoundVillain();
		ICondition cond5 = new NotFallingPerson();
		ICondition cond6 = new FoundStatic();

		//condition lists
		ArrayList<ICondition> listBottom = new ArrayList<ICondition>();
		listBottom.add(cond0);
		ArrayList<ICondition> listFalling = new ArrayList<ICondition>();
		listFalling.add(cond1);
		ArrayList<ICondition> listFull = new ArrayList<ICondition>();
		listFull.add(cond2);
		ArrayList<ICondition> listFound = new ArrayList<ICondition>();
		listFound.add(cond3);
		ArrayList<ICondition> listNotSaved = new ArrayList<ICondition>();
		listNotSaved.add(cond5);
		listNotSaved.add(cond6);

		//actions
		IAction acBottom = new LeaveSpawn();
		IAction acFalling = new SavePerson();
		IAction acFull = new EmptyBag();
		IAction acFound = new CaptureVillain();
		//IAction acIdle = new StayIdle();

		//rules
		Rule rBottom = new Rule(listBottom, acBottom, "rBottom");
		Rule rFalling = new Rule(listFalling, acFalling, "rFalling");
		Rule rFull = new Rule(listFull, acFull, "rFull");
		Rule rFound = new Rule(listFound, acFound, "rFound");
		//Rule rNotSaved = new Rule(listNotSaved,acIdle,"rNotSaved");

		//rule list
		ArrayList<Rule> r = new ArrayList<Rule>();
		r.add(rBottom);
		r.add(rFalling);
		//rules.add(rNotSaved); //saves everyone before capturing villains
		r.add(rFull);
		r.add(rFound);
		
		rules = r;

	}

	public void scanWorld(StateObservation so) {

		w = new World(so);
		w.readMap();
		//w.printMap();

	}

	public ACTIONS think() {

		Rule r = trigger();

		if (r != null) {

			return r.getAction().doAction(w);

		} else {

			return ACTIONS.ACTION_NIL;
		}

	}

	public Rule trigger() {

		ArrayList<Rule> candidates = new ArrayList<Rule>();
		Rule r = null;

		if (rules != null) {
			for (int i = 0; i < rules.size(); i++) {
				r = rules.get(i);
				if (r.isTrue(w)) {

					candidates.add(r);
				}
			}
		}

		if (candidates != null) {
			if (candidates.size() == 1) {
				r = candidates.get(0);
			}
			if (candidates.size() > 1) {
				r = conflictResolution(candidates);
			}
		}

		//System.out.println(r.name);

		return r;
	}

	public Rule conflictResolution(ArrayList<Rule> c) {

		return c.get(0);
	}

}

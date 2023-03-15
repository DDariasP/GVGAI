package si2023.diegodarias741.engine;

import java.util.ArrayList;

import si2023.diegodarias741.agent.*;

public class Engine {

	private ArrayList<Rule> rules;

	public Engine(ArrayList<Rule> r) {

		rules = r;
	}

	public Rule trigger(World w) {

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

package si2023.diegodarias741.p05;

import ontology.Types.ACTIONS;

public class NodeAGoMiddle extends TreeNodeAction {

	public NodeAGoMiddle(String n) {
		super(n);
	}

	@Override
	public ACTIONS doAction(AgentWorld89 w) {

		int xCurrent = (int) w.avatar.xAxis / w.block;
		int yCurrent = (int) w.avatar.yAxis / w.block;
		int xGoal = w.rows / 2;
		int yGoal = w.columns - 3;
		//System.out.println(xCurrent + " " + yCurrent);
		//System.out.println(xGoal + " " + yGoal);

		if (xCurrent < xGoal) {
			return ACTIONS.ACTION_RIGHT;
		}

		if (xCurrent > xGoal) {
			return ACTIONS.ACTION_LEFT;
		}

		if (yCurrent > yGoal) {
			return ACTIONS.ACTION_UP;
		}

		if (yCurrent < yGoal) {
			return ACTIONS.ACTION_DOWN;
		}

		return ACTIONS.ACTION_NIL;

	}

}

package si2023.diegodarias741.p05;

import ontology.Types.ACTIONS;

public class NodeAEmptyBag extends TreeNodeAction {

	public NodeAEmptyBag(String n) {
		super(n);
	}

	@Override
	public ACTIONS doAction(AgentWorld89 w) {

		Boolean flag = false;
		int xCurrent = (int) w.avatar.xAxis / w.block;
		int yCurrent = (int) w.avatar.yAxis / w.block;
		int xGoal = 0;
		int yGoal = 0;
		if (w.immovable != null) {
			int i = 0;
			while (!flag && i < w.immovable.size()) {

				AgentItem agentItem = w.immovable.get(i);

				if (agentItem.name == "jail") {
					flag = true;
					xGoal = (int) agentItem.xAxis / w.block;
					yGoal = (int) agentItem.yAxis / w.block;
				}
				i++;
			}
		}
		
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

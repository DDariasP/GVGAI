package si2023.diegodarias741.p05;

import ontology.Types.ACTIONS;

public class NodeASavePerson extends TreeNodeAction {

	public NodeASavePerson(String n) {
		super(n);
	}

	@Override
	public ACTIONS doAction(AgentWorld89 w) {

		int distance = 999;
		int xCurrent = (int) w.avatar.xAxis / w.block;
		int yCurrent = (int) w.avatar.yAxis / w.block;
		int xGoal = 0;
		int yGoal = 0;

		if (w.movable != null) {
			for (int i = 0; i < w.movable.size(); i++) {

				AgentItem agentItem = w.movable.get(i);

				if (agentItem.name == "falling") {
					int x = (int) agentItem.xAxis / w.block;
					int y = (int) agentItem.yAxis / w.block;

					// Manhattan distance
					int d = Math.abs(xCurrent - x) + Math.abs(yCurrent - y);
					//System.out.println("distanceToPerson: " + d);

					if (d < distance) {
						xGoal = x;
						yGoal = y;
						distance = d;
						//System.out.println("ShortestDistance: " + distance);
					}
				}
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

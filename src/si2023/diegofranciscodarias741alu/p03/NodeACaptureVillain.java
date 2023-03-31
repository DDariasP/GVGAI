package si2023.diegofranciscodarias741alu.p03;

import ontology.Types.ACTIONS;

public class NodeACaptureVillain extends TreeNodeAction {

	public NodeACaptureVillain(String n) {
		super(n);
	}

	@Override
	public ACTIONS doAction(AgentWorld89 w) {

		int distance = 999;
		int xCurrent = (int) w.avatar.xAxis / w.block;
		int yCurrent = (int) w.avatar.yAxis / w.block;
		int xGoal = 0;
		int yGoal = 0;

		if (w.npcs != null) {
			for (int i = 0; i < w.npcs.size(); i++) {

				AgentItem agentItem = w.npcs.get(i);

				if (agentItem.name == "villain") {
					int x = (int) agentItem.xAxis / w.block;
					int y = (int) agentItem.yAxis / w.block;

					// Manhattan distance
					int d = Math.abs(xCurrent - x) + Math.abs(yCurrent - y);
					//System.out.println("distanceToVillain: " + d);

					if (d < distance) {
						xGoal = x;
						yGoal = y;
						distance = d;
						//System.out.println("ShortestDistance: " + distance);
					}
				}
			}
		}

		/*		System.out.println("xCurrent: " + xCurrent);
				System.out.println("yCurrent: " + yCurrent);
				System.out.println("xGoal: " + xGoal);
				System.out.println("yGoal: " + yGoal);*/

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

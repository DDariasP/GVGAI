package si2023.diegodarias741.actions;

import ontology.Types.ACTIONS;

import si2023.diegodarias741.agent.*;
import si2023.diegodarias741.engine.*;

public class SavePerson implements IAction {

	@Override
	public ACTIONS doAction(World w) {

		int distance = 999;
		int xCurrent = (int) w.avatar.xAxis / w.block;
		int yCurrent = (int) w.avatar.yAxis / w.block;
		int xGoal = 0;
		int yGoal = 0;

		if (w.movable != null) {
			for (int i = 0; i < w.movable.size(); i++) {

				Item item = w.movable.get(i);

				if (item.name == "falling") {
					int x = (int) item.xAxis / w.block;
					int y = (int) item.yAxis / w.block;

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

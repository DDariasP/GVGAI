package si2023.diegodarias741.p04.actions;

import ontology.Types.ACTIONS;
import si2023.diegodarias741.p04.fsm.*;

public class EmptyBag implements IAction {

	@Override
	public ACTIONS doAction(World89 w) {

		Boolean flag = false;
		int xCurrent = (int) w.avatar.xAxis / w.block;
		int yCurrent = (int) w.avatar.yAxis / w.block;
		int xGoal = 0;
		int yGoal = 0;
		if (w.immovable != null) {
			int i = 0;
			while (!flag && i < w.immovable.size()) {

				Item item = w.immovable.get(i);

				if (item.name == "jail") {
					flag = true;
					xGoal = (int) item.xAxis / w.block;
					yGoal = (int) item.yAxis / w.block;
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

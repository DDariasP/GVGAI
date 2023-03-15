package si2023.diegodarias741.actions;

import ontology.Types.ACTIONS;
import si2023.diegodarias741.agent.*;
import si2023.diegodarias741.engine.*;

public class SavePerson implements IAction {

	@Override
	public ACTIONS doAction(World w) {

		int x = 999;
		int y = 999;
		if (w.movable != null) {
			for (int i = 0; i < w.movable.size(); i++) {

				Item item = w.movable.get(i);

				//Manhattan distance
				if (item.name == "falling" && item.xAxis < x && item.yAxis < y) //closest falling person
				{
					x = (int) item.xAxis / w.block;
					y = (int) item.yAxis / w.block;
				}
			}
		}

		//high priority
		if (w.avatar.yAxis > y) {
			return ACTIONS.ACTION_UP;
		}

		if (w.avatar.xAxis > x) {
			return ACTIONS.ACTION_RIGHT;
		}

		if (w.avatar.xAxis < x) {
			return ACTIONS.ACTION_LEFT;
		}

		//low priority
		if (w.avatar.yAxis < y) {
			return ACTIONS.ACTION_DOWN;
		}

		return ACTIONS.ACTION_NIL;
	}

}

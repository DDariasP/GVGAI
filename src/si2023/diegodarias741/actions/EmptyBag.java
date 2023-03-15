package si2023.diegodarias741.actions;

import ontology.Types.ACTIONS;
import si2023.diegodarias741.agent.*;
import si2023.diegodarias741.engine.*;

public class EmptyBag implements IAction {

	@Override
	public ACTIONS doAction(World w) {

		Boolean flag = false;
		int x = 0;
		int y = 0;
		if (w.immovable != null) {
			int i = 0;
			while (!flag && i < w.immovable.size()) {

				Item item = w.immovable.get(i);

				if (item.name == "jail") {
					flag = true;
					x = (int) item.xAxis / w.block;
					y = (int) item.yAxis / w.block;
				}
				i++;
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

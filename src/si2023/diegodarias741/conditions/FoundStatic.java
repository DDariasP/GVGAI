package si2023.diegodarias741.conditions;

import si2023.diegodarias741.agent.Item;
import si2023.diegodarias741.agent.World;
import si2023.diegodarias741.engine.ICondition;

public class FoundStatic implements ICondition {

	@Override
	public Boolean isTrue(World w) {

		Boolean flag = false;
		if (w.movable != null) {
			int i = 0;
			while (!flag && i < w.movable.size()) {

				Item item = w.movable.get(i);

				if (item.name == "person") 
				{
					flag = true;
				}
				i++;
			}
		}
		return flag;
	}

}

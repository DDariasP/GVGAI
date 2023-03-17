package si2023.diegodarias741.p03.conditions;

import si2023.diegodarias741.p03.agent.*;
import si2023.diegodarias741.p03.engine.*;

public class FoundVillain implements ICondition {

	@Override
	public Boolean isTrue(World w) {
		
		Boolean flag = false;
		if (w.npcs != null) {
			int i = 0;
			while (!flag && i < w.npcs.size()) {

				Item item = w.npcs.get(i);

				if (item.name == "villain") 
				{
					flag = true;
				}
				i++;
			}
		}
		return flag;
	}

}

package si2023.diegodarias741.p04.conditions;

import si2023.diegodarias741.p04.fsm.*;

public class FoundVillain implements ICondition {

	@Override
	public Boolean isTrue(World89 w) {
		
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

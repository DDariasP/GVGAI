package si2023.diegodarias741.p03.conditions;

import si2023.diegodarias741.p03.agent.*;
import si2023.diegodarias741.p03.engine.*;

public class FallingPerson implements ICondition {

	@Override
	public Boolean isTrue(World w) {
		
		Boolean flag = false;
		if (w.movable != null) {
			int i = 0;
			while (!flag && i < w.movable.size()) {

				Item item = w.movable.get(i);

				if (item.name == "falling") 
				{
					flag = true;
				}
				i++;
			}
		}
		return flag;
	}

}

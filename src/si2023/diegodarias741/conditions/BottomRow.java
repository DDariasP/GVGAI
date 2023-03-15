package si2023.diegodarias741.conditions;

import si2023.diegodarias741.agent.*;
import si2023.diegodarias741.engine.*;

public class BottomRow implements ICondition {

	@Override
	public Boolean isTrue(World w) {

		int yCurrent = (int) w.avatar.yAxis / w.block;
		//System.out.println(yCurrent);

		// true when hero @ bottom row
		return (yCurrent == 12);
	}

}

package si2023.diegodarias741.p03.conditions;

import si2023.diegodarias741.p03.agent.*;
import si2023.diegodarias741.p03.engine.*;

public class BottomRow implements ICondition {

	@Override
	public Boolean isTrue(World w) {

		int yCurrent = (int) w.avatar.yAxis / w.block;
		//System.out.println(yCurrent);

		// true when hero @ bottom row
		return (yCurrent == 12);
	}

}

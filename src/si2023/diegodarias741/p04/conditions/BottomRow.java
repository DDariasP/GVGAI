package si2023.diegodarias741.p04.conditions;

import si2023.diegodarias741.p04.fsm.*;

public class BottomRow implements ICondition {

	@Override
	public Boolean isTrue(World89 w) {

		int yCurrent = (int) w.avatar.yAxis / w.block;
		//System.out.println(yCurrent);

		// true when hero @ bottom row
		return (yCurrent == 12);
	}

}

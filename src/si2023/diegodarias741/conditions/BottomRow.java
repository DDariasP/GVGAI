package si2023.diegodarias741.conditions;

import si2023.diegodarias741.agent.*;
import si2023.diegodarias741.engine.*;

public class BottomRow implements ICondition {

	@Override
	public Boolean isTrue(World w) {
	
		//true when hero @ bottom row
		return ( w.avatar.xAxis == (w.rows - 1) );
	}

}

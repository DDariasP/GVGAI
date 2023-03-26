package si2023.diegodarias741.p03.conditions;

import si2023.diegodarias741.p03.agent.*;
import si2023.diegodarias741.p03.engine.*;

public class NotFallingPerson implements ICondition {

	@Override
	public Boolean isTrue(World w) {

		ICondition c = new FallingPerson();
		
		return ( ! c.isTrue(w) );
	}

}

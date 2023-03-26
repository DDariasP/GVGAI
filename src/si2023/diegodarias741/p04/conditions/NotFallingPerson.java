package si2023.diegodarias741.p04.conditions;

import si2023.diegodarias741.p04.fsm.*;

public class NotFallingPerson implements ICondition {

	@Override
	public Boolean isTrue(World89 w) {

		ICondition c = new FallingPerson();
		
		return ( ! c.isTrue(w) );
	}

}

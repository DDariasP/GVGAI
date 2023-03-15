package si2023.diegodarias741.conditions;

import si2023.diegodarias741.agent.World;
import si2023.diegodarias741.engine.ICondition;

public class NotFallingPerson implements ICondition {

	@Override
	public Boolean isTrue(World w) {

		ICondition c = new FallingPerson();
		
		return ( ! c.isTrue(w) );
	}

}

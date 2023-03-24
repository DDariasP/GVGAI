package si2023.diegodarias741.p05;

import java.util.HashMap;



public class CFullBag implements ICondition {

	@Override
	public Boolean isTrue(AgentWorld89 w) {

		HashMap<Integer, Integer> bag = w.world.getAvatarResources();
		//System.out.println(bag.get(13));

		//max villains(13) in bag = 8
		if (bag.get(13) != null) {	
			
			return (bag.get(13) == 8);
			
		} else {
			
			return false;
		}
	}

}

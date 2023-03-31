package si2023.diegofranciscodarias741alu.p02;

import java.util.HashMap;



public class FullBag implements ICondition {

	@Override
	public Boolean isTrue(World89 w) {

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

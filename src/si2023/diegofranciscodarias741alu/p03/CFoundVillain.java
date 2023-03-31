package si2023.diegofranciscodarias741alu.p03;


public class CFoundVillain implements ICondition {

	@Override
	public Boolean isTrue(AgentWorld89 w) {
		
		Boolean flag = false;
		if (w.npcs != null) {
			int i = 0;
			while (!flag && i < w.npcs.size()) {

				AgentItem agentItem = w.npcs.get(i);

				if (agentItem.name == "villain") 
				{
					flag = true;
				}
				i++;
			}
		}
		return flag;
	}

}

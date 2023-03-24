package si2023.diegodarias741.p05;


public class CFallingPerson implements ICondition {

	@Override
	public Boolean isTrue(AgentWorld89 w) {
		
		Boolean flag = false;
		if (w.movable != null) {
			int i = 0;
			while (!flag && i < w.movable.size()) {

				AgentItem agentItem = w.movable.get(i);

				if (agentItem.name == "falling") 
				{
					flag = true;
				}
				i++;
			}
		}
		return flag;
	}

}

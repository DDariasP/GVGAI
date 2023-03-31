package si2023.diegofranciscodarias741alu.p03;

public class CVillainLTX implements ICondition {

	@Override
	public Boolean isTrue(AgentWorld89 w) {

		int X = 5;
		int count = 0;
		Boolean flag = true;
		if (w.npcs != null) {
			int i = 0;
			while (flag && i < w.npcs.size()) {

				AgentItem agentItem = w.npcs.get(i);
				//System.out.println(agentItem);

				if (agentItem.name == "villain") {
					count++;
					if (count >= X) {
						flag = false;
					}
				}
				i++;
			}
		}

		//System.out.println("count: " + count);
		//System.out.println("flag: " + flag);

		return flag;
	}

}

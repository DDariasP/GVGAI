package si2023.diegofranciscodarias741alu.p01;




public class FoundVillain implements ICondition {

	@Override
	public Boolean isTrue(World w) {
		
		Boolean flag = false;
		if (w.npcs != null) {
			int i = 0;
			while (!flag && i < w.npcs.size()) {

				Item item = w.npcs.get(i);

				if (item.name == "villain") 
				{
					flag = true;
				}
				i++;
			}
		}
		return flag;
	}

}

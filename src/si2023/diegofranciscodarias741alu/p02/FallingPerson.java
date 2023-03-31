package si2023.diegofranciscodarias741alu.p02;



public class FallingPerson implements ICondition {

	@Override
	public Boolean isTrue(World89 w) {
		
		Boolean flag = false;
		if (w.movable != null) {
			int i = 0;
			while (!flag && i < w.movable.size()) {

				Item item = w.movable.get(i);

				if (item.name == "falling") 
				{
					flag = true;
				}
				i++;
			}
		}
		return flag;
	}

}

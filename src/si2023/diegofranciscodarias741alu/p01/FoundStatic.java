package si2023.diegofranciscodarias741alu.p01;




public class FoundStatic implements ICondition {

	@Override
	public Boolean isTrue(World w) {

		Boolean flag = false;
		if (w.movable != null) {
			int i = 0;
			while (!flag && i < w.movable.size()) {

				Item item = w.movable.get(i);

				if (item.name == "person") 
				{
					flag = true;
				}
				i++;
			}
		}
		return flag;
	}

}

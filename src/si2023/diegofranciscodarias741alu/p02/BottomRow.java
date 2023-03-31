package si2023.diegofranciscodarias741alu.p02;



public class BottomRow implements ICondition {

	@Override
	public Boolean isTrue(World89 w) {

		int yCurrent = (int) w.avatar.yAxis / w.block;
		//System.out.println(yCurrent);

		// true when hero @ bottom row
		return (yCurrent == 12);
	}

}

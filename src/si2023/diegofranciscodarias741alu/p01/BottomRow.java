package si2023.diegofranciscodarias741alu.p01;

public class BottomRow implements ICondition {

	@Override
	public Boolean isTrue(World w) {

		int yCurrent = (int) w.avatar.yAxis / w.block;
		//System.out.println(yCurrent);

		// true when hero @ bottom row
		return (yCurrent == 12);
	}

}

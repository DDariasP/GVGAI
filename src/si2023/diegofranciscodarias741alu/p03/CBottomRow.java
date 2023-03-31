package si2023.diegofranciscodarias741alu.p03;

public class CBottomRow implements ICondition {

	@Override
	public Boolean isTrue(AgentWorld89 w) {

		int yCurrent = (int) w.avatar.yAxis / w.block;
		//System.out.println(yCurrent);

		// true when hero @ bottom row
		return (yCurrent == w.columns - 2);
	}

}

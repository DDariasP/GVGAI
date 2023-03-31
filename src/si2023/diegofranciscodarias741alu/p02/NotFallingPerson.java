package si2023.diegofranciscodarias741alu.p02;


public class NotFallingPerson implements ICondition {

	@Override
	public Boolean isTrue(World89 w) {

		ICondition c = new FallingPerson();
		
		return ( ! c.isTrue(w) );
	}

}

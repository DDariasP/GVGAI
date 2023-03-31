package si2023.diegofranciscodarias741alu.p01;



public class NotFallingPerson implements ICondition {

	@Override
	public Boolean isTrue(World w) {

		ICondition c = new FallingPerson();
		
		return ( ! c.isTrue(w) );
	}

}

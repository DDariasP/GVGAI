package si2023.diegofranciscodarias741alu.p01;


import java.util.ArrayList;


public class Rule {

	private ArrayList<ICondition> conditions;
	private IAction action;
	public String name;

	public Rule(ArrayList<ICondition> c, IAction a,String n) {
		conditions = c;
		action = a;
		name = n;
	}

	public Boolean isTrue(World w) {
		
		Boolean flag = true;
		int i = 0;
		while (flag && i < conditions.size()) {

			ICondition c = conditions.get(i);

			if (!c.isTrue(w)) //when at least one condition isn't true
			{
				flag = false;
			}
			i++;
		}

		return flag;
	}

	public ArrayList<ICondition> getConditions() {
		return conditions;
	}

	public IAction getAction() {
		return action;
	}

}

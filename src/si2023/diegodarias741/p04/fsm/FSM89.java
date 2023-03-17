package si2023.diegodarias741.p04.fsm;

import java.util.LinkedList;

import si2023.diegodarias741.p04.conditions.*;
import si2023.diegodarias741.p04.states.*;

public class FSM89 extends FSM {

	public FSM89() {

		State s1 = new State1();
		State s2 = new State2();
		State s3 = new State3();
		State s4 = new State4();

		Transition t;
		LinkedList<Transition> list;

		//s1 - bottomRow
		list = new LinkedList<>();
		t = new Transition(new FallingPerson(), s2); //SavePerson
		list.add(t);
		t = new Transition(new FoundVillain(), s3); //CaptureVillain
		list.add(t);
		s1.setList(list);

		//s2 - fallingPerson
		list = new LinkedList<>();
		t = new Transition(new NotFallingPerson(), s3); //CaptureVillain
		list.add(t);
		s2.setList(list);

		//s3 - foundVillain
		list = new LinkedList<>();
		t = new Transition(new FullBag(), s4); //EmptyBag
		list.add(t);
		s3.setList(list);

		//s4 - fullBag
		list = new LinkedList<>();
		t = new Transition(new BottomRow(), s1); //LeaveSpawn
		list.add(t);
		s4.setList(list);

		initialState = s1;
		currentState = initialState;

	}

}

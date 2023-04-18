package si2023.diegofranciscodarias741alu.p04;

import java.util.Comparator;

public class ComparatorINode implements Comparator<INode> {

	@Override
	public int compare(INode o1, INode o2) {
		return o1.costFunction() - o2.costFunction();
	}
}

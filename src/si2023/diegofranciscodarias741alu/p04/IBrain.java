package si2023.diegofranciscodarias741alu.p04;

import java.util.LinkedList;

import ontology.Types.ACTIONS;

public interface IBrain {

	public LinkedList<INode> findPath(IState world);

	public LinkedList<INode> getPath(INode start, INode goal);

	public ACTIONS think(INode current, INode next);
}

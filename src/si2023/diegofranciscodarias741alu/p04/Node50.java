package si2023.diegofranciscodarias741alu.p04;

import java.util.Iterator;
import java.util.LinkedList;

public class Node50 implements INode {

	public int x;
	public int y;
	public Item item;

	public int traversed;
	public int heuristic;

	public INode parent;
	public LinkedList<INode> allSucc;
	public LinkedList<INode> validSucc;

	public Boolean open;
	public Boolean closed;
	public Boolean reachable;

	public Node50(int i, int j) {
		x = i;
		y = j;
		allSucc = new LinkedList<INode>();
		validSucc = new LinkedList<INode>();
	}

	public Node50(int i, int j, Item n) {
		x = i;
		y = j;
		item = new Item(n);
		allSucc = new LinkedList<INode>();
		validSucc = new LinkedList<INode>();
	}

	@Override
	public void setX(int a) {
		x = a;
	}

	@Override
	public int getX() {

		return x;
	}

	@Override
	public void setY(int a) {
		y = a;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setItem(Item i) {
		item = i;

	}

	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public int costFunction() {
		return traversed + heuristic;
	}

	@Override
	public void setTraversed(int a) {
		traversed = a;
	}

	@Override
	public int getTraversed() {
		return traversed;
	}

	@Override
	public void setHeuristic(int a) {
		heuristic = a;
	}

	@Override
	public int getHeuristic() {
		return heuristic;
	}

	@Override
	public void setParent(INode n) {
		parent = n;
	}

	@Override
	public INode getParent() {
		return parent;
	}

	@Override
	public void setAllSucc(LinkedList<INode> list) {
		allSucc = list;
	}

	@Override
	public LinkedList<INode> getAllSucc() {
		return allSucc;
	}

	@Override
	public void setValidSucc(LinkedList<INode> list) {
		validSucc = list;
	}

	@Override
	public LinkedList<INode> getValidSucc() {
		validSucc.clear();
		//int i = 0;
		for (Iterator<INode> iterator = allSucc.iterator(); iterator.hasNext();) {
			//i++;
			INode n = iterator.next();
			if (n.getReachable()) {
				//System.out.println("succ " + i + "\n" + n);
				//System.out.println("reachable=" + n.getReachable());
				validSucc.add(n);
			}
		}
		return validSucc;
	}

	@Override
	public void setOpen(Boolean b) {
		open = b;
	}

	@Override
	public Boolean getOpen() {
		return open;
	}

	@Override
	public void setClosed(Boolean b) {
		closed = b;
	}

	@Override
	public Boolean getClosed() {
		return closed;
	}

	@Override
	public void setReachable(Boolean b) {
		reachable = b;
	}

	@Override
	public Boolean getReachable() {
		return reachable;
	}

	@Override
	public String toString() {
		return ("name: " + item.name + ", category: " + item.category + ", itype: " + item.itype + ", x: " + x + ", y: "
				+ y);
	}

}

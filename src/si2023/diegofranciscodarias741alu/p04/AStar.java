package si2023.diegofranciscodarias741alu.p04;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

import ontology.Types.ACTIONS;

public class AStar implements IBrain {

	private IState world;

	@Override
	public LinkedList<INode> findPath(IState w) {

		world = w;

		INode start = world.getNodeAvatar();
		INode goal = world.getNodeGoal();

		return getPath(start, goal);
	}

	@Override
	public LinkedList<INode> getPath(INode start, INode goal) {

		PriorityQueue<INode> open = new PriorityQueue<INode>(new ComparatorINode());
		LinkedHashSet<INode> closed = new LinkedHashSet<INode>();

		INode current = start;
		open.add(current);
		current.setOpen(true);
		while (open.size() > 0) {
			//System.out.println("open size=" + open.size());
			current = open.poll();
			if (current == goal) {
				System.out.println("goal reached");
				return getPath(current);
			}
			//System.out.println("current\n" + current);
			//System.out.println("reachable=" + current.getReachable());
			current.setOpen(false);
			closed.add(current);
			current.setClosed(true);
			addValidSucc(open, current);
		}
		return getPath(start);
	}

	private void addValidSucc(PriorityQueue<INode> open, INode current) {
		LinkedList<INode> succ = current.getValidSucc();
		//System.out.println(succ.size());
		for (Iterator<INode> ite1 = succ.iterator(); ite1.hasNext();) {
			INode iNode = ite1.next();
			if (!iNode.getClosed()) {
				if (current.getTraversed() + 1 < iNode.getTraversed()) {
					if (iNode.getOpen()) {
						open.remove(iNode);
					}
					iNode.setParent(current);
					iNode.setTraversed(current.getTraversed() + 1);
					//System.out.println("valid succ\n"+iNode);
					open.add(iNode);
					iNode.setOpen(true);
				}
			}
		}
	}

	private LinkedList<INode> getPath(INode last) {
		LinkedList<INode> path = new LinkedList<INode>();
		while (last.getParent() != last) {
			path.addFirst(last);
			last = last.getParent();
		}
		path.addFirst(last.getParent());
		return path;
	}

	@Override
	public ACTIONS think(INode current, INode next) {
		ACTIONS a = world.doTransition(current, next);
		return a;
	}

}

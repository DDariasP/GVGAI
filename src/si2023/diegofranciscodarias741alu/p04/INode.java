package si2023.diegofranciscodarias741alu.p04;

import java.util.LinkedList;

public interface INode {

	public void setX(int a);
	public int getX();
	public void setY(int a);
	public int getY();
	public void setItem(Item item);
	public Item getItem();

	public int costFunction();
	public void setTraversed(int a);
	public int getTraversed();
	public void setHeuristic(int a);
	public int getHeuristic();

	public void setParent(INode n);
	public INode getParent();
	public void setAllSucc(LinkedList<INode> list);
	public LinkedList<INode> getAllSucc();
	public void setValidSucc(LinkedList<INode> list);
	public LinkedList<INode> getValidSucc();

	public void setOpen(Boolean b);
	public Boolean getOpen();
	public void setClosed(Boolean b);
	public Boolean getClosed();
	public void setReachable(Boolean b);
	public Boolean getReachable();

}

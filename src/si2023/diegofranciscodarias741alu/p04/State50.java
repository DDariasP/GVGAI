package si2023.diegofranciscodarias741alu.p04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import core.game.Observation;
import core.game.StateObservation;
import ontology.Types.ACTIONS;
import tools.Vector2d;

public class State50 implements IState {

	public StateObservation world;
	public ArrayList<Observation>[][] grid;
	public Node50[][] graph;
	public ArrayList<Item> trees, snakes, goals;
	public int avatarX;
	public int avatarY;
	public static int goalX;
	public static int goalY;
	public static int width;
	public static int height;
	public static int block;

	public State50(StateObservation so) {
		world = so;
		grid = world.getObservationGrid();
		width = grid.length;
		height = grid[0].length;
		graph = new Node50[width][height]; //empty graph
		block = world.getBlockSize();

		//item lists
		treeList(world.getImmovablePositions());
		snakeList(world.getImmovablePositions());
		goalList(world.getPortalsPositions());
		Vector2d pos = world.getAvatarPosition();
		avatarX = (int) pos.x / block;
		avatarY = (int) pos.y / block;
		goalX = (int) goals.get(0).xAxis / block;
		goalY = (int) goals.get(0).yAxis / block;

		//graph
		newGraph();
	}

	private void treeList(ArrayList<Observation>[] ilist) {
		if (ilist != null) {

			trees = new ArrayList<Item>();

			for (int i = 0; i < ilist.length; i++) {
				for (int j = 0; j < ilist[i].size(); j++) {

					Item item = new Item(ilist[i].get(j));
					//System.out.println(item.toString());

					//tree
					if (item.itype == 0) {
						item.name = "tree";
						item.symbol = 'T';
						trees.add(item);
					}
				}
			}
		}
	}

	private void snakeList(ArrayList<Observation>[] ilist) {
		if (ilist != null) {

			snakes = new ArrayList<Item>();

			for (int i = 0; i < ilist.length; i++) {
				for (int j = 0; j < ilist[i].size(); j++) {

					Item item = new Item(ilist[i].get(j));
					//System.out.println(item.toString());

					//snake
					if (item.itype == 3) {
						item.name = "snake";
						item.symbol = 'S';
						snakes.add(item);
					}
				}
			}
		}
	}

	private void goalList(ArrayList<Observation>[] plist) {
		if (plist != null) {

			goals = new ArrayList<Item>();

			for (int i = 0; i < plist.length; i++) {
				for (int j = 0; j < plist[i].size(); j++) {

					Item item = new Item(plist[i].get(j));
					//System.out.println(item.toString());

					//every portal
					item.name = "goal";
					item.symbol = 'G';
					goals.add(item);
				}
			}
		}
	}

	private void newGraph() {

		//tree nodes
		for (Iterator<Item> ite1 = trees.iterator(); ite1.hasNext();) {
			Item item = ite1.next();
			int x = (int) item.xAxis / block;
			int y = (int) item.yAxis / block;
			graph[x][y] = new Node50(x, y, item);
			graph[x][y].setHeuristic(100); //worst
		}

		//snake nodes
		for (Iterator<Item> ite2 = snakes.iterator(); ite2.hasNext();) {
			Item item = ite2.next();
			int x = (int) item.xAxis / block;
			int y = (int) item.yAxis / block;
			graph[x][y] = new Node50(x, y, item);
			graph[x][y].setHeuristic(0); //best
		}

		//goal node
		graph[goalX][goalY] = new Node50(goalX, goalY, goals.get(0));
		graph[goalX][goalY].setHeuristic(25); //good

		//avatar node
		graph[avatarX][avatarY] = new Node50(avatarX, avatarY,
				new Item("avatar", 'A', 0, 0, avatarX * block, avatarY * block));
		graph[avatarX][avatarY].setHeuristic(75); //bad

		//empty nodes
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (graph[i][j] == null) {
					graph[i][j] = new Node50(i, j, new Item("empty", ' ', -1, -1, i * block, j * block));
					graph[i][j].setHeuristic(75); //bad
				}
			}
		}

		//initialise attributes
		newAttributes();

		//mark obstacles
		markUnreachable();

		//add all adjacent nodes
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (graph[i][j] != null) {
					addAllSucc(i, j);
				}
			}
		}

		// prints graph row by row
		String s = "\t";

		//inverted
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				s = s + graph[i][j].item.symbol;
			}
			System.out.println(s);
			s = "\t";
		}
		System.out.println("-------------------------------------");
	}

	private void newAttributes() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				graph[x][y].setTraversed(Integer.MAX_VALUE);
				graph[x][y].setHeuristic(graph[x][y].getHeuristic() + Math.abs(goalX - x) + Math.abs(goalY - y));
				graph[x][y].setParent(graph[x][y]);
				graph[x][y].setOpen(false);
				graph[x][y].setClosed(false);
			}
		}
	}

	private void markUnreachable() {
		char symbol;
		boolean flag;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				symbol = graph[x][y].item.symbol;
				flag = true;
				if (symbol == 'T') {
					flag = false;
				}
				graph[x][y].setReachable(flag);
			}
		}
	}

	private void addAllSucc(int x, int y) {
		LinkedList<INode> allSucc = new LinkedList<>();
		if (getAdjNode(x + 1, y) != null) {
			allSucc.add(getAdjNode(x + 1, y));
		}
		if (getAdjNode(x - 1, y) != null) {
			allSucc.add(getAdjNode(x - 1, y));
		}
		if (getAdjNode(x, y + 1) != null) {
			allSucc.add(getAdjNode(x, y + 1));
		}
		if (getAdjNode(x, y - 1) != null) {
			allSucc.add(getAdjNode(x, y - 1));
		}
		graph[x][y].setAllSucc(allSucc);
	}

	private Node50 getAdjNode(int x, int y) {
		if (x < 0 || y < 0 || x > width - 1 || y > height - 1) {
			return null;
		} else {
			return graph[x][y];
		}
	}

	@Override
	public INode getNodeAvatar() {
		return graph[avatarX][avatarY];
	}

	@Override
	public INode getNodeGoal() {
		return graph[goalX][goalY];
	}

	@Override
	public ACTIONS doTransition(INode current, INode next) {

		int xCurrent = current.getX();
		int yCurrent = current.getY();
		int xNext = next.getX();
		int yNext = next.getY();

		if (xCurrent < xNext) {
			return ACTIONS.ACTION_RIGHT;
		}

		if (xCurrent > xNext) {
			return ACTIONS.ACTION_LEFT;
		}

		if (yCurrent > yNext) {
			return ACTIONS.ACTION_UP;
		}

		if (yCurrent < yNext) {
			return ACTIONS.ACTION_DOWN;
		}

		return ACTIONS.ACTION_NIL;
	}

}

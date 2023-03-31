package si2023.diegofranciscodarias741alu.p00;

import java.util.ArrayList;
import core.game.Observation;
import core.game.StateObservation;

public class AgentWorld50 {

	public StateObservation world;
	public ArrayList<Observation>[][] grid;
	public char[][] map;
	public ArrayList<AgentItem> movable, immovable, portals, npcs;
	public AgentItem avatar;
	public int rows, columns, block;

	public AgentWorld50(StateObservation o) {

		scanWorld(o);
	}

	public void scanWorld(StateObservation so) {

		world = so;
		grid = world.getObservationGrid();
		rows = grid.length;
		//System.out.println("rows: " + rows);
		columns = grid[0].length;
		//System.out.println("columns: " + columns);
		map = new char[rows][columns]; // empty map
		block = world.getBlockSize();

		// item lists
		immovableList(world.getImmovablePositions());
		portalList(world.getPortalsPositions());
		avatar = new AgentItem("avatar", 'A', 0, world.getAvatarType(), world.getAvatarPosition());

		readMap();

	}

	public void immovableList(ArrayList<Observation>[] ilist) {

		if (ilist != null) {

			immovable = new ArrayList<AgentItem>();

			for (int i = 0; i < ilist.length; i++) {
				for (int j = 0; j < ilist[i].size(); j++) {

					AgentItem agentItem = new AgentItem(ilist[i].get(j));
					// item.printItem();

					// every immovable item
					/*
					 * item.setName("???"); item.setSymbol('I');
					 * immovable.add(item);
					 */

					// tree
					if (agentItem.itype == 0) {
						agentItem.setName("tree");
						agentItem.setSymbol('T');
						immovable.add(agentItem);
					}

					// snake
					if (agentItem.itype == 3) {
						agentItem.setName("snake");
						agentItem.setSymbol('S');
						immovable.add(agentItem);
					}
				}

			}
		}
	}

	public void portalList(ArrayList<Observation>[] plist) {

		if (plist != null) {

			portals = new ArrayList<AgentItem>();

			for (int i = 0; i < plist.length; i++) {
				for (int j = 0; j < plist[i].size(); j++) {

					AgentItem agentItem = new AgentItem(plist[i].get(j));
					// item.printItem();

					// every portal
					agentItem.setName("goal");
					agentItem.setSymbol('G');
					portals.add(agentItem);
				}
			}

		}
	}

	public void readMap() {

		// blank map
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {

				map[i][j] = ' ';
			}
		}

		// adds immovable items
		if (immovable != null) {
			for (int i = 0; i < immovable.size(); i++) {
				AgentItem agentItem = immovable.get(i);
				// item.printItem();
				int x = (int) agentItem.xAxis / block;
				int y = (int) agentItem.yAxis / block;
				map[x][y] = agentItem.symbol;
			}
		}

		// adds portals
		if (portals != null) {
			for (int i = 0; i < portals.size(); i++) {
				AgentItem agentItem = portals.get(i);
				// item.printItem();
				int x = (int) agentItem.xAxis / block;
				int y = (int) agentItem.yAxis / block;
				map[x][y] = agentItem.symbol;
			}
		}

		// adds hero
		if (avatar != null) {
			int x = (int) avatar.xAxis / block;
			int y = (int) avatar.yAxis / block;
			map[x][y] = avatar.symbol;
		}

	}

	public void printMap() {

		// prints map row by row
		String s = "\t";
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {

				s = s + map[j][i];
			}
			System.out.println(s);
			s = "\t";
		}
		System.out.println("-------------------------------------");
	}

}

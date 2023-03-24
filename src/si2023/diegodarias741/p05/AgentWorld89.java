package si2023.diegodarias741.p05;

import java.util.ArrayList;
import core.game.Observation;
import core.game.StateObservation;

public class AgentWorld89 {

	public StateObservation world;
	public ArrayList<Observation>[][] grid;
	public char[][] map;
	public ArrayList<AgentItem> movable, immovable, portals, npcs;
	public AgentItem avatar;
	public int rows, columns, block;

	public AgentWorld89(StateObservation o) {
		
		scanWorld(o);
	}
	
	public void scanWorld(StateObservation so) {
		
		world = so;
		grid = world.getObservationGrid();
		rows = grid.length;
		// System.out.println("rows: " + rows);
		columns = grid[0].length;
		// System.out.println("columns: " + columns);
		map = new char[rows][columns]; // empty map
		block = world.getBlockSize();

		// item lists
		movableList(world.getMovablePositions());
		immovableList(world.getImmovablePositions());
		portalList(world.getPortalsPositions());
		npcList(world.getNPCPositions());
		avatar = new AgentItem("avatar", 'H', 0, world.getAvatarType(), world.getAvatarPosition());

		readMap();

	}

	public void movableList(ArrayList<Observation>[] mlist) {

		if (mlist != null) {

			movable = new ArrayList<AgentItem>();

			for (int i = 0; i < mlist.length; i++) {
				for (int j = 0; j < mlist[i].size(); j++) {

					AgentItem agentItem = new AgentItem(mlist[i].get(j));
					// item.printItem();

					// every movable item
					/*					item.setName("???");
										item.setSymbol('M');
										movable.add(item);*/

					// static person
					if (agentItem.itype == 16) {
						agentItem.setName("person");
						agentItem.setSymbol('T');
						movable.add(agentItem);
					}

					// falling person
					if (agentItem.itype == 18) {
						agentItem.setName("falling");
						agentItem.setSymbol('T');
						movable.add(agentItem);
					}

					// bullets
					if (agentItem.itype == 19) {
						agentItem.setName("bullet");
						agentItem.setSymbol('-');
						movable.add(agentItem);
					}
				}
			}
		}
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

					// death row
					if (agentItem.itype == 4) {
						agentItem.setName("death");
						agentItem.setSymbol('^');
						immovable.add(agentItem);
					}

					// walls
					if (agentItem.itype == 0) {
						agentItem.setName("wall");
						agentItem.setSymbol('W');
						immovable.add(agentItem);
					}

					// clouds
					if (agentItem.itype == 3) {
						agentItem.setName("cloud");
						agentItem.setSymbol('O');
						immovable.add(agentItem);
					}

					// jail
					if (agentItem.itype == 6) {
						agentItem.setName("jail");
						agentItem.setSymbol('J');
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
					agentItem.setName("portal");
					agentItem.setSymbol('P');
					portals.add(agentItem);
				}
			}

		}
	}

	public void npcList(ArrayList<Observation>[] nlist) {

		if (nlist != null) {

			npcs = new ArrayList<AgentItem>();

			for (int i = 0; i < nlist.length; i++) {
				for (int j = 0; j < nlist[i].size(); j++) {

					AgentItem agentItem = new AgentItem(nlist[i].get(j));
					// item.printItem();

					// every NPC
					/*
					 * item.setName("???"); item.setSymbol('N'); npcs.add(item);
					 */

					// villains
					if (agentItem.category == 3) {
						agentItem.setName("villain");
						agentItem.setSymbol('V');
						npcs.add(agentItem);
					}

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

		// adds movable items
		if (movable != null) {
			for (int i = 0; i < movable.size(); i++) {
				AgentItem agentItem = movable.get(i);
				// item.printItem();
				int x = (int) agentItem.xAxis / block;
				int y = (int) agentItem.yAxis / block;
				map[x][y] = agentItem.symbol;
			}
		}

		// adds NPCs
		if (npcs != null) {
			for (int i = 0; i < npcs.size(); i++) {
				AgentItem agentItem = npcs.get(i);
				// item.printItem();
				int x = (int) agentItem.xAxis / block;
				int y = (int) agentItem.yAxis / block;
				map[x][y] = agentItem.symbol;
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

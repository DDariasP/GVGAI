package si2023.diegodarias741.p04.fsm;

import java.util.ArrayList;
import core.game.Observation;
import core.game.StateObservation;
import si2023.diegodarias741.p03.agent.World;

public class World89 {

	public StateObservation world;
	public ArrayList<Observation>[][] grid;
	public char[][] map;
	public ArrayList<Item> movable, immovable, portals, npcs;
	public Item avatar;
	public int rows, columns, block;

	public World89(StateObservation o) {
		
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
		avatar = new Item("avatar", 'H', 0, world.getAvatarType(), world.getAvatarPosition());

		readMap();

	}

	public void movableList(ArrayList<Observation>[] mlist) {

		if (mlist != null) {

			movable = new ArrayList<Item>();

			for (int i = 0; i < mlist.length; i++) {
				for (int j = 0; j < mlist[i].size(); j++) {

					Item item = new Item(mlist[i].get(j));
					// item.printItem();

					// every movable item
					/*					item.setName("???");
										item.setSymbol('M');
										movable.add(item);*/

					// static person
					if (item.itype == 16) {
						item.setName("person");
						item.setSymbol('T');
						movable.add(item);
					}

					// falling person
					if (item.itype == 18) {
						item.setName("falling");
						item.setSymbol('T');
						movable.add(item);
					}

					// bullets
					if (item.itype == 19) {
						item.setName("bullet");
						item.setSymbol('-');
						movable.add(item);
					}
				}
			}
		}
	}

	public void immovableList(ArrayList<Observation>[] ilist) {

		if (ilist != null) {

			immovable = new ArrayList<Item>();

			for (int i = 0; i < ilist.length; i++) {
				for (int j = 0; j < ilist[i].size(); j++) {

					Item item = new Item(ilist[i].get(j));
					// item.printItem();

					// every immovable item
					/*
					 * item.setName("???"); item.setSymbol('I');
					 * immovable.add(item);
					 */

					// death row
					if (item.itype == 4) {
						item.setName("death");
						item.setSymbol('^');
						immovable.add(item);
					}

					// walls
					if (item.itype == 0) {
						item.setName("wall");
						item.setSymbol('W');
						immovable.add(item);
					}

					// clouds
					if (item.itype == 3) {
						item.setName("cloud");
						item.setSymbol('O');
						immovable.add(item);
					}

					// jail
					if (item.itype == 6) {
						item.setName("jail");
						item.setSymbol('J');
						immovable.add(item);
					}
				}

			}
		}
	}

	public void portalList(ArrayList<Observation>[] plist) {

		if (plist != null) {

			portals = new ArrayList<Item>();

			for (int i = 0; i < plist.length; i++) {
				for (int j = 0; j < plist[i].size(); j++) {

					Item item = new Item(plist[i].get(j));
					// item.printItem();

					// every portal
					item.setName("portal");
					item.setSymbol('P');
					portals.add(item);
				}
			}

		}
	}

	public void npcList(ArrayList<Observation>[] nlist) {

		if (nlist != null) {

			npcs = new ArrayList<Item>();

			for (int i = 0; i < nlist.length; i++) {
				for (int j = 0; j < nlist[i].size(); j++) {

					Item item = new Item(nlist[i].get(j));
					// item.printItem();

					// every NPC
					/*
					 * item.setName("???"); item.setSymbol('N'); npcs.add(item);
					 */

					// villains
					if (item.category == 3) {
						item.setName("villain");
						item.setSymbol('V');
						npcs.add(item);
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
				Item item = movable.get(i);
				// item.printItem();
				int x = (int) item.xAxis / block;
				int y = (int) item.yAxis / block;
				map[x][y] = item.symbol;
			}
		}

		// adds NPCs
		if (npcs != null) {
			for (int i = 0; i < npcs.size(); i++) {
				Item item = npcs.get(i);
				// item.printItem();
				int x = (int) item.xAxis / block;
				int y = (int) item.yAxis / block;
				map[x][y] = item.symbol;
			}
		}

		// adds immovable items
		if (immovable != null) {
			for (int i = 0; i < immovable.size(); i++) {
				Item item = immovable.get(i);
				// item.printItem();
				int x = (int) item.xAxis / block;
				int y = (int) item.yAxis / block;
				map[x][y] = item.symbol;
			}
		}

		// adds portals
		if (portals != null) {
			for (int i = 0; i < portals.size(); i++) {
				Item item = portals.get(i);
				// item.printItem();
				int x = (int) item.xAxis / block;
				int y = (int) item.yAxis / block;
				map[x][y] = item.symbol;
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

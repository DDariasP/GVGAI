package si2023.diegodarias741.p03.actions;

import ontology.Types.ACTIONS;
import si2023.diegodarias741.p03.agent.*;
import si2023.diegodarias741.p03.engine.*;

public class CaptureVillain implements IAction {

	@Override
	public ACTIONS doAction(World w) {

		/*		int x = 999;
				int y = 999;
				if (w.npcs != null) {
					for (int i = 0; i < w.npcs.size(); i++) {
		
						Item item = w.npcs.get(i);
		
						// Manhattan distance
						if (item.name == "villain" && item.xAxis < x && item.yAxis < y) // closest villain
						{
							x = (int) item.xAxis / w.block;
							y = (int) item.yAxis / w.block;
						}
					}
				}
		
				int xCurrent = (int) w.avatar.xAxis / w.block;
				int yCurrent = (int) w.avatar.yAxis / w.block;
		
				// high priority
				if (xCurrent < x && w.map[xCurrent][yCurrent] != 'W') {
					return ACTIONS.ACTION_RIGHT;
				}
		
				if (xCurrent > x && w.map[xCurrent][yCurrent] != 'W') {
					return ACTIONS.ACTION_LEFT;
				}
				if (yCurrent < y && w.map[xCurrent][yCurrent] != 'W') {
					return ACTIONS.ACTION_UP;
				}
		
				// low priority
				if (yCurrent > y && w.map[xCurrent][yCurrent] != 'W') {
					return ACTIONS.ACTION_DOWN;
				}
		
				return ACTIONS.ACTION_NIL;*/

		int distance = 999;
		int xCurrent = (int) w.avatar.xAxis / w.block;
		int yCurrent = (int) w.avatar.yAxis / w.block;
		int xGoal = 0;
		int yGoal = 0;

		if (w.npcs != null) {
			for (int i = 0; i < w.npcs.size(); i++) {

				Item item = w.npcs.get(i);

				if (item.name == "villain") {
					int x = (int) item.xAxis / w.block;
					int y = (int) item.yAxis / w.block;

					// Manhattan distance
					int d = Math.abs(xCurrent - x) + Math.abs(yCurrent - y);
					//System.out.println("distanceToVillain: " + d);

					if (d < distance) {
						xGoal = x;
						yGoal = y;
						distance = d;
						//System.out.println("ShortestDistance: " + distance);
					}
				}
			}
		}

		/*		System.out.println("xCurrent: " + xCurrent);
				System.out.println("yCurrent: " + yCurrent);
				System.out.println("xGoal: " + xGoal);
				System.out.println("yGoal: " + yGoal);*/
		
		if (xCurrent < xGoal) {
			return ACTIONS.ACTION_RIGHT;
		}
		
		if (xCurrent > xGoal) {
			return ACTIONS.ACTION_LEFT;
		}
		
		if (yCurrent > yGoal) {
			return ACTIONS.ACTION_UP;
		}
		
		if (yCurrent < yGoal) {
			return ACTIONS.ACTION_DOWN;
		}

		return ACTIONS.ACTION_NIL;

	}

}

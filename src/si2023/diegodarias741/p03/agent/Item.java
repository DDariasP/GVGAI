package si2023.diegodarias741.p03.agent;

import core.game.Observation;
import tools.Vector2d;

public class Item {

	public String name;
	public char symbol;
	public int category;
	public int itype;
	public double xAxis;
	public double yAxis;

	public Item(String n, char s, int c, int t, Vector2d v) {
		name = n;
		symbol = s;
		category = c;
		itype = t;
		xAxis = v.x;
		yAxis = v.y;
	}

	public Item(Observation o) {
		name = "???";
		symbol = 'X';
		category = o.category;
		itype = o.itype;
		xAxis = o.position.x;
		yAxis = o.position.y;
	}

	public void setName(String n) {

		name = n;
	}

	public void setSymbol(char s) {

		symbol = s;
	}

	public void printItem() {
		System.out.println("name: " + name + ", symbol: " + symbol + ", category: " + category + ", itype: " + itype
				+ ", xAxis: " + xAxis + ", yAxis: " + yAxis);
	}

}

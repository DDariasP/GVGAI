package si2023.diegofranciscodarias741alu.p04;

import core.game.Observation;
import tools.Vector2d;

public class Item {

	public String name;
	public char symbol;
	public int category;
	public int itype;
	public double xAxis;
	public double yAxis;

	public Item(String n, char s, int c, int t, double a, double b) {
		name = n;
		symbol = s;
		category = c;
		itype = t;
		xAxis = a;
		yAxis = b;
	}

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

	public Item(Item i) {
		name = i.name;
		symbol = i.symbol;
		category = i.category;
		itype = i.itype;
		xAxis = i.xAxis;
		yAxis = i.yAxis;
	}

	@Override
	public String toString() {
		return ("name: " + name + ", category: " + category + ", itype: " + itype + ", symbol: " + symbol + ", xAxis: "
				+ xAxis + ", yAxis: " + yAxis);
	}

}

package si2023.diegofranciscodarias741alu.p03;

import core.game.Observation;
import tools.Vector2d;

public class AgentItem {

	public String name;
	public char symbol;
	public int category;
	public int itype;
	public double xAxis;
	public double yAxis;

	public AgentItem(String n, char s, int c, int t, Vector2d v) {
		name = n;
		symbol = s;
		category = c;
		itype = t;
		xAxis = v.x;
		yAxis = v.y;
	}

	public AgentItem(Observation o) {
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

	@Override
	public String toString() {
		return ("name: " + name + ", category: " + category + ", itype: " + itype + ", xAxis: " + xAxis + ", yAxis: "
				+ yAxis);
	}

}

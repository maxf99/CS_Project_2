
public class Hole extends Terrain {

	//regulation holes are 4.25 in in diameter
	
	public Hole (double position) {
		//position is the center of the hole
		this.setValidSpot(true);
		this.setLowerLimit(position - 2.125);
		this.setUpperLimit(position + 2.125);
	}
	//constructor
}

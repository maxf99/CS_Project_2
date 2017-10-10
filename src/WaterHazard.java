
public class WaterHazard extends Terrain {

	public WaterHazard (double length, double position) {
		this.setValidSpot(false);
		this.createLowerLimit(length, position);
		this.createUpperLimit(length, position);
	}
	//constructor
}

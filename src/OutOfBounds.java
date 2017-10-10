
public class OutOfBounds extends Terrain {

	public OutOfBounds (double lowerLimit, double upperLimit) {
		this.setValidSpot(false);
		this.setLowerLimit(lowerLimit);
		this.setUpperLimit(upperLimit);
	}
	//constructor
	
	@Override
	public boolean inside (double position) {
		if (position >= this.getUpperLimit()) {
			return true;
		}
		else {
			return false;
		}
	}
	//updated inside method taking into consideration that the upper limit is infinity
	//returns true when ball is within the bounds
}


abstract public class Terrain {

	private double upperLimit;
	private double lowerLimit;
	private double position;
	private double length;
	private boolean validSpot;
	//variables
	
	public double getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(double upperLimit) {
		this.upperLimit = upperLimit;
	}
	public double getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public boolean isValidSpot() {
		return validSpot;
	}
	public void setValidSpot(boolean validSpot) {
		this.validSpot = validSpot;
	}
	public double getPosition() {
		return position;
	}
	public void setPosition(double position) {
		this.position = position;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	//getters and setters
	
	public void createUpperLimit(double length, double position) {
		double halfDistance = length / 2;
		this.setUpperLimit(position + halfDistance);
	}
	public void createLowerLimit(double length, double position) {
		double halfDistance = length / 2;
		this.setLowerLimit(position - halfDistance);
	}
	//determine upper and lower bounds
	
	public boolean inside (double position) {
		if (position >= lowerLimit && position <= upperLimit) {
			return true;
		}
		else {
			return false;
		}
	}
	//returns true when ball is within the bounds
}

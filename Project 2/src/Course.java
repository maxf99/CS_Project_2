import java.util.Random;

public class Course {

	Random rand = new Random();
	//construct a new random instance
	
	WaterHazard WH1;
	WaterHazard WH2;
	WaterHazard WH3;
	SandBunker SB1;
	SandBunker SB2;
	SandBunker SB3;
	//All possible necessary terrains
	
	private Double hazards; //equivalent of an int, but needs to be an int because .nextDouble is used to enable multiplication of a decimal CAST IF POSSIBLE
	private Double length; //length of course
	private Double ratioFairwayGreen; //% of the course the boundary between the fairway and the green is
	private Double ratioHoleGreen; //% of the way into the green the hole is
		//constraints
	private int waterHazards = 0;
	private int sandBunkers = 0;
	private boolean weightedRandom = true; //switch between weighted randoms, and unbiased randoms. RECOMENDED: TRUE
	//variables
	
 	public double getHazards() {
		return hazards;
	}
	public void setHazards(double hazards) {
		this.hazards = hazards;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getRatioFairwayGreen() {
		return ratioFairwayGreen;
	}
	public void setRatioFairwayGreen(double ratioFairwayGreen) {
		this.ratioFairwayGreen = ratioFairwayGreen;
	}
	public double getRatioHoleGreen() {
		return ratioHoleGreen;
	}
	public void setRatioHoleGreen(double ratioHoleGreen) {
		this.ratioHoleGreen = ratioHoleGreen;
	}
	//constraints' getters and setters
	
	@Deprecated
	public void setHazardsRandom() {
		if (weightedRandom) {
			double random = rand.nextDouble();
			double hold = (2 / (Math.pow (( random * 10), 2) * 0.25 + 1) + 1);
			//holding variable with algorithm
				//Algorithm info
			//in normal math, where x is the random: (2/.25x^2+1)+1, then round to nearest whole number
			if (hold % 1 >= 0.5){ //rounding
				hazards = (hold - (hold % 1) + 1);
			}
			else {
				hazards = (hold - (hold % 1));
			}
			//the % 1 restricts numbers to only integers, while maintaining double data type
			//if random is 0: 3 hazards; if rand is 1 or 2: 2 hazards; if rand is anything else: 1 hazard
		}
		else {
			hazards = ((rand.nextDouble() * 2) + 1) % 1;
			//[1, 3] hazards
		}
	}
	@Deprecated
	public void setLengthRandom() {
		if (weightedRandom) {
			double random = rand.nextDouble();
			double hold = Math.pow( ((Math.cbrt(200) + Math.cbrt (400)) / 1000) * (random * 1000) - Math.cbrt (400), 3) + 500;
			//holding variable with algorithm
				//Algorithm info
			//in normal math, where x is the random: (((^3√200+^3√400)/1000)x-^3√400)^3+500
			if (hold % 1 >= 0.5){ //rounding
				length = (hold - (hold % 1) + 1);
			}
			else {
				length = (hold - (hold % 1));
			}
		}
		else {
			length = ((rand.nextDouble() * 600) + 100) % 1;
			//[100, 700] unit course
		}
	}
	@Deprecated
	public void setRatioFairwayGreenRandom() {
		if (weightedRandom) {
			double random = rand.nextDouble();
			double hold = Math.pow( ((Math.cbrt(10) + Math.cbrt (5)) / 1000) * (random * 1000) - Math.cbrt (5), 3) + 65;
			//holding variable with algorithm
				//Algorithm info
			//in normal math, where x is the random: (((^3√10+^3√5)/1000)x-^3√5)^3+65
			if (hold % 1 >= 0.5){ //rounding
				ratioFairwayGreen = (hold - (hold % 1) + 1);
			}
			else {
				ratioFairwayGreen = (hold - (hold % 1));
			}
		}
		else {
			ratioFairwayGreen = ((rand.nextDouble() * 15) + 60) % 1;
			//[60, 75] percent
		}
	}
	@Deprecated
	public void setRatioHoleGreenRandom() {
		if (weightedRandom) {
			double random = rand.nextDouble();
			double hold = Math.pow( ((Math.cbrt(5) + Math.cbrt (5)) / 1000) * (random * 1000) - Math.cbrt (5), 3) + 90;
			//holding variable with algorithm
				//Algorithm info
			//in normal math, where x is the random: (((^3√5+^3√5)/1000)x-^3√5)^3+90
			if (hold % 1 >= 0.5){ //rounding
				ratioHoleGreen = (hold - (hold % 1) + 1);
			}
			else {
				ratioHoleGreen = (hold - (hold % 1));
			}
		}
		else {
			ratioHoleGreen = ((rand.nextDouble() * 10) + 85) % 1;
			//[85, 95] percent
		}
	}
	//constraints' random setters
	
	public void constraintGenerationRandom() {
		this.setHazardsRandom();
		this.setLengthRandom();
		this.setRatioFairwayGreenRandom();
		this.setRatioHoleGreenRandom();
	}
	public void constraintGeneration(double hazards, double length, double ratioFairwayGreen, double ratioHoleGreen) {
		this.setHazards(hazards);
		this.setLength(length);
		this.setRatioFairwayGreen(ratioFairwayGreen);
		this.setRatioHoleGreen(ratioHoleGreen);
	}
	//constraints' generators
	
	public double hazardLengthGenerator() {
		if (weightedRandom) {
			double random = rand.nextDouble();
			double hold = Math.pow( ((Math.cbrt(5) + Math.cbrt (10)) / 1000) * (random * 1000) - Math.cbrt (10), 3) + 20;
			//holding variable with algorithm
				//Algorithm info
			//in normal math, where x is the random: (((^3√200+^3√400)/1000)x-^3√400)^3+500
			if (hold % 1 >= 0.5){ //rounding
				return (hold - (hold % 1) + 1);
			}
			else {
				return (hold - (hold % 1));
			}
		}
		else {
			return ((rand.nextDouble() * 15) + 10) % 1;
			//[10, 25] units long hazard
		}
	}
	public double hazardPositionGeneration() {
		
	}
	//hazard limit generators
	
	public void hazardsGenerationRandom() {
		if (hazards == null) {
			this.constraintGenerationRandom();
		}
		for (int i = 1; i <= hazards; i++) {
			double random = rand.nextDouble();
			if (random < 0.5) {
				waterHazards++;
			}
			else {
				sandBunkers++;
			}
			//randomly delegate sand bunkers and water hazards
		}
		switch (waterHazards) {
			case 3:
				WH3 = new WaterHazard(this.hazardLengthGenerator(), position);
				WH2 = new WaterHazard(this.hazardLengthGenerator(), position);
				WH1 = new WaterHazard(this.hazardLengthGenerator(), position);
				break;
			case 2:
				WH3 = null;
				WH2 = new WaterHazard(this.hazardLengthGenerator(), position);
				WH1 = new WaterHazard(this.hazardLengthGenerator(), position);
				break;
			case 1:
				WH3 = null;
				WH2 = null;
				WH1 = new WaterHazard(this.hazardLengthGenerator(), position);
				break;
			case 0:
				WH3 = null;
				WH2 = null;
				WH1 = null;
				break;
		}
		switch (sandBunkers) {
			case 3:
				SB3 = new SandBunker(this.hazardLengthGenerator(), position);
				SB2 = new SandBunker(this.hazardLengthGenerator(), position);
				SB1 = new SandBunker(this.hazardLengthGenerator(), position);
				break;
			case 2:
				SB3 = null;
				SB2 = new SandBunker(this.hazardLengthGenerator(), position);
				SB1 = new SandBunker(this.hazardLengthGenerator(), position);
				break;
			case 1:
				SB3 = null;
				SB2 = null;
				SB1 = new SandBunker(this.hazardLengthGenerator(), position);
				break;
			case 0:
				SB3 = null;
				SB2 = null;
				SB1 = null;
				break;
		}
		//construct hazards
	}
	//hazard generation
	
}
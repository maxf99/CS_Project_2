import java.util.Random;

public class test {

	static Random rand = new Random();
	
	public static void main (String[] args) {
		for (int i = 0; i < 20; i++) {
			double random = rand.nextDouble();
			double hold = Math.pow( ((Math.cbrt(5) + Math.cbrt (10)) / 1000) * (random * 1000) - Math.cbrt (10), 3) + 20;
			//holding variable with algorithim
				//algorithim info
			//in normal math, where x is the random: (2/.25x^2+1)+1, then round to nearest whole number
			if (hold % 1 >= 0.5){ //rounding
				System.out.println(hold - (hold % 1) + 1);
			}
			else {
				System.out.println(hold - (hold % 1));
			}
		}
	}
}

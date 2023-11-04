package adventureGame;

import java.util.Random;

public class Snake extends Obstacle {

	public Snake() {
		super(4, "Yılan", rndDamage(), 12, 0);
	}

	public static int rndDamage() {
		Random rnd = new Random();
		return rnd.nextInt(3, 7);

	}
}

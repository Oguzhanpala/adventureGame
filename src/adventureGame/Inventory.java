package adventureGame;

public class Inventory {
	private Weapon weapon;
	private Armor armor;
	private String firewood;
	private String food;
	private String water;
	private String snake;

	public Inventory(String firewood, String food, String water, String snake) {
		this.weapon = new Weapon(0, "Yumruk", 0, 0);
		this.armor = new Armor(0, "Paçavra", 0, 0);
		this.firewood = firewood;
		this.food = food;
		this.water = water;
		this.snake = snake;

	}

	public Armor getArmor() {
		return this.armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Weapon getWeapon() {
		return this.weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public String getFirewood() {
		return firewood;
	}

	public void setFirewood(String firewood) {
		this.firewood = firewood;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getSnake() {
		return snake;
	}

	public void setSnake(String snake) {
		this.snake = snake;
	}

}

package adventureGame;

import java.util.Scanner;

public class Player {

	private Inventory inventory;
	private int damage;
	private int health;
	private int defHealth;
	private int money;
	private String playerName;
	private String charName;
	private Scanner input = new Scanner(System.in);

	public Player(String playerName) {
		this.playerName = playerName;
		this.inventory = new Inventory();
	}

	public int getTotalDamage() {
		return damage + this.getInventory().getWeapon().getDamage();
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health < 0) {
			health = 0;
		}
		this.health = health;
	}

	public int getDefHealth() {
		return defHealth;
	}

	public void setDefHealth(int defHealth) {
		this.defHealth = defHealth;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return playerName;
	}

	public void setName(String name) {
		this.playerName = name;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void selectChar() {
		Samurai samurai = new Samurai();
		Knight knight = new Knight();
		Archer archer = new Archer();
		GameChar[] charList = { samurai, archer, knight };
		System.out.println("Karakterler");
		System.out.println("----------------------------------------------------------------------------");

		for (GameChar gameChar : charList) {

			System.out.println("ID : " + gameChar.getId() + "\t Karakter: " + gameChar.getName() + "\t Hasar: "
					+ gameChar.getDamage() + "\t Sağlık: " + gameChar.getHealth() + "\t Para: " + gameChar.getMoney());
		}
		System.out.println("----------------------------------------------------------------------------");
		System.out.print("Lütfen bir karakter seçiniz : ");
		int selectChar = input.nextInt();

		switch (selectChar) {
		case 1:
			initPlayer(samurai);
			break;
		case 2:
			initPlayer(archer);
			break;
		case 3:
			initPlayer(knight);
			break;
		default:
			initPlayer(samurai);
			break;
		}

	}

	public void charInfo() {

		System.out.println();
		System.out.println("Karakter : " + this.getName() + "\t Hasar: " + this.getTotalDamage() + "\t Bloklama: "
				+ this.getInventory().getArmor().getBlock() + "\t Sağlık: " + this.getHealth() + "\t Para: "
				+ this.getMoney());

	}

	public void printInfo() {
		System.out.println();
		System.out.println("Silahınız : " + this.getInventory().getWeapon().getName() + "\t Zırhınız: "
				+ this.getInventory().getArmor().getName() + "\t Bloklama: " + this.getInventory().getArmor().getBlock()
				+ "\t Hasarınız: " + this.getTotalDamage() + "\t Sağlık: " + this.getHealth() + "\t Para: "
				+ this.getMoney());
	}

	public void initPlayer(GameChar gameChar) {
		this.setDamage(gameChar.getDamage());
		this.setHealth(gameChar.getHealth());
		this.setDefHealth(gameChar.getHealth());
		this.setMoney(gameChar.getMoney());
		this.setName(gameChar.getName());
	}

}

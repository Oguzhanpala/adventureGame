package adventureGame;

public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean onLocation() {
		System.out.println("Güvenli evdesiniz..");
		System.out.println("Canınız yenilendi..");
		this.getPlayer().setHealth(this.getPlayer().getDefHealth());
		return true;
	}

}

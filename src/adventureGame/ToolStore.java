package adventureGame;

import javax.print.attribute.standard.PrinterInfo;

public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Mağaza");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onLocation() {
		System.out.println();
		System.out.println("-------Mağazaya hoşgeldiniz.---------");

		boolean showMenu = true;

		while (showMenu) {
			System.out.println("------------------------------------------");
			System.out.println("1-Silahlar \n" + "2-Zırhlar \n" + "3-Çıkış yap");
			System.out.println("------------------------------------------");
			System.out.print("Seçiminiz : ");
			int selectCase = input.nextInt();
			System.out.println();

			while (selectCase < 1 || selectCase > 3) {
				System.out.println("Geçersiz değer, tekrar deneyiniz..");
				selectCase = input.nextInt();
			}
			switch (selectCase) {
			case 1:
				printweapon();
				buyWeapon();
				this.getPlayer().printInfo();
				break;
			case 2:
				printArmor();
				buyArmor();
				this.getPlayer().printInfo();
				break;
			case 3:
				System.out.println("Birdaha beklerizz..");
				showMenu = false;
				break;
			}
		}
		return true;
	}

	private void printArmor() {
		System.out.println("------Zırhlar------");
		System.out.println("---------------------------------");
		for (Armor armor : Armor.armors()) {
			System.out.println(armor.getId() + " -->" + " Zırh: " + armor.getName() + "\t Blok: " + armor.getBlock()
					+ "\t Para: " + armor.getPrice());
		}
		System.out.println("0 --> Geri dön");
		System.out.println("---------------------------------");
	}

	public void buyArmor() {
		System.out.print("Bir seçim yapınız : ");
		int selectedArmorId = input.nextInt();
		while (selectedArmorId < 0 || selectedArmorId > Armor.armors().length) {
			System.out.println("Geçersiz bir değer girdiniz. Tekrar deneyiniz.");
			selectedArmorId = input.nextInt();
		}
		if (selectedArmorId != 0) {
			Armor selectedArmor = Armor.getArmorObjById(selectedArmorId);
			if (selectedArmor != null) {
				if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("Yetersiz bakiye. Paranız : " + this.getPlayer().getMoney());
				} else {

					int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
					this.getPlayer().getInventory().setArmor(selectedArmor);
				}
			}
		}
		

	}

	public void printweapon() {
		System.out.println("-----Silahlar-----");
		System.out.println("------------------------------------");
		for (Weapon weapon : Weapon.weapons()) {
			System.out.println(weapon.getId() + " -->" + " Silah: " + weapon.getName() + "\t Hasar: "
					+ weapon.getDamage() + "\t Para: " + weapon.getPrice());
		}
		System.out.println("0 --> Geri dön");
		System.out.println("------------------------------------");
	}

	public void buyWeapon() {
		System.out.print("Bir seçim yapınız : ");
		int selectWeaponId = input.nextInt();
		while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
			System.out.println("Geçersiz bir değer girdiniz. Tekrar deneyiniz.");
			selectWeaponId = input.nextInt();
		}
		if (selectWeaponId != 0) {
			Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponId);
			if (selectedWeapon != null) {
				if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("Yetersiz bakiye. Paranız : " + this.getPlayer().getMoney());
				} else {
					int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
					this.getPlayer().getInventory().setWeapon(selectedWeapon);
				}
			}
		}
	}

}

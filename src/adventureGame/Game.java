package adventureGame;

import java.util.Scanner;

public class Game {

	public void start() {
		Scanner input = new Scanner(System.in);

		System.out.println("Macera oyununa hoşgeldiniz.");
		System.out.print("Lütfen bir isim giriniz : ");
		String playerName = input.nextLine();
		Player player = new Player(playerName);
		System.out.println(player.getName() + " macera oyununa hoşgeldin.");
		player.selectChar();
		
		Location location = null;
		while (true) {
			player.charInfo();
			System.out.println();
			System.out.println("------Bölgeler------");
			System.out.println("--------------------------------------------------------");
			System.out.println("1-Güvenli Ev");
			System.out.println("2-Silah ve Zırh Mağazası");
			System.out.println("3-Mağara");
			System.out.println("4-Orman");
			System.out.println("5-Nehir");
			System.out.println("6-Maden");
			System.out.println("0-Çıkış Yap");
			System.out.println("--------------------------------------------------------");
			System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
			int selectLog = input.nextInt();
			switch (selectLog) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new ToolStore(player);
				break;
			case 3:
				location = new Cave(player);
				break;
			case 4:
				location = new Forest(player);
				break;
			case 5:
				location = new River(player);
				break;
			case 6:
				location=new Mine(player);
				break;
			case 0:
				location = null;
				break;
			default:
				System.out.println("Lütfen geçerli bir bölge giriniz.");
				continue;

			}
			if (location == null) {
				System.out.println("Oyundan çıkış yapılıyor....\nÇıkış yapıldı.");
				break;
			}
			if (!location.onLocation()) {
				System.out.println("Game Over");
				break;
			}
		}

	}
}

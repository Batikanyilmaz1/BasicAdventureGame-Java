
public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Tool Store");
		
	}
	
	public boolean getLocation() {
		System.out.println();
		System.out.println("Current Money: "+ player.getMoney());
		System.out.println();
		System.out.println("1. Weapons");
		System.out.println("2. Armors");
		System.out.println("3. Exit");
		System.out.print("Your Choice: ");
		
		int selTool = scan.nextInt();
		int selItemID;
		switch(selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}
		
		
		return true;
	}
	
	public int armorMenu() {
		System.out.println("1. Light Armor\t --> Armor: 1, Cost: 15");
		System.out.println("2. Medium Armor\t --> Armor: 3, Cost: 25");
		System.out.println("3. Heavy Armor\t --> Armor: 5, Cost: 40");
		System.out.println("4. Exit");
		System.out.print("Your Choice: ");
		int selArmorID = scan.nextInt();
		return selArmorID;
		
	}
	
	public void buyArmor(int itemID) {
		int armor=0,cost=0;
		String aName=null;
		
		switch(itemID) {
		case 1:
			armor = 1;
			aName = "Light Armor";
			cost = 15;
		break;
		case 2:
			armor = 3;
			aName = "Medium Armor";
			cost = 25;
		break;
		case 3:
			armor = 5;
			aName = "Heavy Armor";
			cost = 40;
		break;
		case 4:
		System.out.println("Exiting");
		break;
		default:
			System.out.println("Please Choose Valid Action!");
		break;
		}
		
		if(cost > 0) {
		if(player.getMoney() >= cost) {
			
		player.getInv().setArmor(armor);
		player.getInv().setaName(aName);
		player.setMoney(player.getMoney()-cost);
		System.out.println("You Bought a new Armor! Your Current Armor is "+ player.getInv().getArmor());
		System.out.println("Your Remaining Money 1is "+player.getMoney());
		}else {
			System.out.println("Not Enough Money!");
		}
	}
		
	}
	
	public int weaponMenu() {
		System.out.println("1. Pistol \t --> Damage: 2, Cost: 25");
		System.out.println("2. Sword \t --> Damage: 3, Cost: 35");
		System.out.println("3. Riffle \t --> Damage: 7, Cost: 45");
		System.out.println("4. Exit");
		System.out.print("Your Choice: ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}
	public void buyWeapon(int itemID) {
		int damage=0,cost=0;
		String wName=null;
		
		switch(itemID) {
		case 1:
			damage = 2;
			wName = "Pistol";
			cost = 25;
		break;
		case 2:
			damage = 3;
			wName = "Sword";
			cost = 35;
		break;
		case 3:
			damage = 7;
			wName = "Riffle";
			cost = 45;
		break;
		case 4:
		System.out.println("Exiting");
		break;
		default:
			System.out.println("Please Choose Valid Action!");
		break;
		}
		
		if(cost > 0) {
		if(player.getMoney() > cost) {
			
		player.getInv().setDamage(damage);
		player.getInv().setwName(wName);
		player.setMoney(player.getMoney()-cost);
		System.out.println("You Bought a new Weapon! Your Current Damage is "+ (player.getDamage()+player.getTotalDamage()));
		System.out.println("Your Remaining Money is "+player.getMoney());
		}else {
			System.out.println("Not Enough Money!");
		}
	}

		
	}

}

import java.util.Scanner;

public class Player {
	private int damage,health,money,rHealth;
	private String name,cName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}
	
	public void selectChar() {
		switch(charMenu()) {
		case 1:
			initPlayer("Samurai",5,21,15);
			break;
			
		case 2:
			initPlayer("Archer",7,18,20);
			break;
		
		case 3:
			initPlayer("Knight",8,24,5);
			break;
		default: 
			initPlayer("Samurai",5,21,15);
			break;
		}
		System.out.println("Your Character is " + getcName() +  "\tDamage: " + getDamage() + " Health: " + getHealth() + " Money: " + getMoney());
	}
	
	 public int charMenu() {
		 System.out.println("Choose Your Character ");
		 System.out.println("1-Samurai \t Damage: 5 \t Health: 21 \t Money: 15");
		 System.out.println("2-Archer \t Damage: 7 \t Health: 18 \t Money: 20");
		 System.out.println("3-Knight \t Damage: 8 \t Health: 24 \t Money: 5");
		 System.out.print("Your Choice is: ");
		 int charID = scan.nextInt();
		 
		 while(charID < 1 || charID > 3) {
			 System.out.print("Please Choose Valid Charachter");
			 charID = scan.nextInt();
			 }
		 
		 return charID;
	 }
	 
	 public int getTotalDamage() {
		 return this.getDamage() + this.getInv().getDamage();
	 }
	 
	 public void initPlayer (String cName, int dmg, int hp, int mny) {
		 setcName(cName);
		 setDamage(dmg);
		 setHealth(hp);
		 setMoney(mny);
		 setRHealth(hp);
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
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getRHealth() {
		return rHealth;
	}

	public void setRHealth(int rHealth) {
		this.rHealth = rHealth;
	}
	
	
	
	
	
}

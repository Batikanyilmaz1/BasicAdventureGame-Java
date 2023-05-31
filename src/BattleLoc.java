
public abstract class BattleLoc extends Location{
	protected Obstacle obstacle;
	protected String award;

	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}
	
	public boolean getLocation() {
		int obsCount =obstacle.count();
		System.out.println("You are in "+ this.getName() + " Now!");
		System.out.println("Watch Out! "+"There are " + obsCount +" "+ obstacle.getName()+" Here!");
		System.out.print("<F>ight or <R>un: ");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		
		if(selCase.equals("F")) {
			if(combat(obsCount)==true) {
				System.out.println("You Defeated the All Enemies in the " + this.getName() + " Area!");
				if(this.award.equals("Food") && player.getInv().isFood() == false) {
				System.out.println("You Have the " + this.award + "!");
				player.getInv().setFood(true);
			}	else if(this.award.equals("Water") && player.getInv().isWater() == false) {
				System.out.println("You Have the " + this.award + "!");
				player.getInv().setWater(true);
			}	else if(this.award.equals("FireWood") && player.getInv().isFirewood() == false) {
				System.out.println("You Have the " + this.award + "!");
				player.getInv().setFirewood(true);
			} 
				return true;
			}
			if(player.getHealth() <= 0) {
				System.out.println("You Died!");
				return false;
			}
		
		}
		return true;
	}
	
	public boolean combat(int obsCount) {
		for(int i = 0; i < obsCount; i++) {
			int defaultObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			
			while(player.getHealth() >= 0 && obstacle.getHealth() > 0) {
				System.out.print("<F>ight or <R>un: ");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if(selCase.equals("F")) {
					System.out.println("You Hit the Enemy!");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if(obstacle.getHealth() > 0) {
					System.out.println();
					System.out.println("The Enemy Hit You!");
					player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));
					afterHit();
					}
				}else {
					return false;
				}
			}
			if(obstacle.getHealth() < player.getHealth()) {
				System.out.println("You Defeated the Enemy!");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Current Money: " + player.getMoney());
				obstacle.setHealth(defaultObsHealth);
			}else {
				return false;
			}
			System.out.println("--------------------------------------------");
		}
		return true;
	}
	
	public void playerStats() {
		System.out.println("Player Stats\n-------");
		System.out.println("Health: " + player.getHealth());
		System.out.println("Damage: " + player.getTotalDamage());
		System.out.println("Money: " + player.getMoney());
		if(player.getInv().getDamage() > 0) {
			System.out.println("Weapon: " + player.getInv().getwName());
		}
		if(player.getInv().getArmor() > 0) {
			System.out.println("Armor: " + player.getInv().getaName());
		}
	}
	
	public void enemyStats() {
		System.out.println("\n" + obstacle.getName()+" Stats\n-------");
		System.out.println("Health: " + obstacle.getHealth());
		System.out.println("Damage: " + obstacle.getDamage());
		System.out.println("Award: " + obstacle.getAward());
	}
	
	public void afterHit() {
		System.out.println("Player Health: " + player.getHealth());
		System.out.println(obstacle.getName() + "Health: " + obstacle.getHealth());
		System.out.println();
	}

}

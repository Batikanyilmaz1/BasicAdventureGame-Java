
public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player, "Safe House");
		// TODO Auto-generated constructor stub
	}
	
	public boolean getLocation() {
		player.setHealth(player.getRHealth());
		System.out.println("Healed!");
		System.out.println("You are in Safe House Now!");
		return true;
	}

}

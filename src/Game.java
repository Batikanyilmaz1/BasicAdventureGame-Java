import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Adventure Game!");
		System.out.println("Before the Game Begins Please Enter Your Name: ");
		//String playerName = scan.nextLine();
		player = new Player("a");
		player.selectChar();
		start();
	}
	
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("=================================================");
			System.out.println();
			System.out.println("Please Choose a Location: ");
			System.out.println();
			System.out.println("1. Safe House --> No Enemy, You Can Rest Here.");
			System.out.println("2. Cave --> You Might Encounter Zombies!");
			System.out.println("3. Forest --> You Might Encounter Vampires!");
			System.out.println("4. River --> You Might Encounter Bears!"); 
			System.out.println("5. Tool Store --> You Can Buy Weapon and Armor.");
			System.out.println();
			System.out.print("The Location You Want to Go is ");
			
			int selLoc = scan.nextInt();
			while(selLoc < 0 || selLoc > 5) {
				System.out.print("Please Choose Valid Location! ");
				selLoc = scan.nextInt();
			}
			
			switch(selLoc){
				case 1:
					location = new SafeHouse(player);
					break;
				case 2:
					location = new Cave(player);
					break;
				case 3:
					location = new Forest(player);
					break;
				case 4:
					location = new River(player);
					break;
				case 5:
					location = new ToolStore(player);
					break;
				default:
					location = new SafeHouse(player);
					break;
			}
			
			if(location.getClass().getName().equals("SafeHouse")){
				if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("You Won the Game!");
					break;
				}
			}
			if (location.getLocation()==false) {
				System.out.println("Game Over!");
				break;
				
			}
		}
	}
}

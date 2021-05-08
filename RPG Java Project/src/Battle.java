//Author: Danny Nsouli
import java.util.ArrayList;
import java.util.LinkedList;

public class Battle {
	
	/*
	 * Sets up the troops of Army 1 by adding nodes using the addNode method
	 * (taking in the first army's linked list as a parameter to modify) based 
	 * on each troop character's attributes until 20 have been chosen; int i is used to
	 * help cycle through each node addition in the way the directions entail for army 1
	*/
	public static void initArmy1(LList l){
		int counter = 0;
		TroopNode trooper = l.head;
	    	for(int i = 1; i<=4; i++){
	    		if(counter == 20){ 
	    			break;
	    		}
	    		if(i == 1){
	    			l.addNode("Monkey", "Ground", 6, 50, "Ground", 0);
	    			counter++;
	    		}
	    		if(i == 2){
	    			l.addNode("Flying Monkey", "Air", 6, 50, "Air", 0);
	    			counter++;
	    		}
	    		if(i == 3){
	    			l.addNode("Wizard", "Ground", 6, 60, "ALL", 0);
	    			counter++;
	    		}
	    		if(i == 4){
	    			l.addNode("Balloon", "Air", 8, 55, "Ground", 0);
	    			counter++;
	    			i = 0;
	    		}
	    	} 
	}
	
	/*
	 * Sets up the troops of Army 2 by adding nodes using the addNode method
	 * (taking in the first army's linked list as a parameter to modify) based 
	 * on each troop character's attributes until 20 have been chosen; int i is used to
	 * help cycle through each node addition in the way the directions entail for Army 2
	*/
	public static void initArmy2(LList l){
		int counter = 0;
		TroopNode trooper = l.head;
	    	for(int i = 2; i<=4; i++){
	    		if(counter == 20){
	    			break;
	    		}
	    		if(i == 1){
	    			l.addNode("Monkey", "Ground", 6, 50, "Ground", 0);
	    			counter++;
	    		}
	    		if(i == 2){
	    			l.addNode("Flying Monkey", "Air", 6, 50, "Air", 0);
	    			counter++;
	    		}
	    		if(i == 3){
	    			l.addNode("Wizard", "Ground", 6, 60, "ALL", 0);
	    			counter++;
	    		}
	    		if(i == 4){
	    			l.addNode("Balloon", "Air", 8, 55, "Ground", 0);
	    			counter++;
	    			i = 0;
	    		}
	    	}
	}
	
	/*
	 * Central method to the game. Sets the last node of each army list as a tail that points
	 * to the head in order to create a circular list to cycle through for each turn as
	 * the next living troop is selected to battle; roundcount keeps count of the rounds; deathcounts 1
	 * and 2 are used to keep track of every death, once 20 troops have died on one side, 
	 * the game will stop to declare a winner and loser. However, while the death counts are
	 * under 20, each round will display stats of the troops involved and the if statements will guide
	 * the deductions to health and additions to total damage based on preferred targets/type combinations
	*/
	public static void startGame(LList l, LList l2){
		l.setTail();
		l2.setTail();
		
		int roundcount = 1;
		int deathcount1 = 0;
		int deathcount2 = 0;
		TroopNode entry1 = l.head;
		TroopNode entry2 = l2.head;
		
		while(deathcount1 < 20 && deathcount2 < 20){
			System.out.println("Round " + roundcount + ": Player 1 " + entry1.name + " (health: " 
								+ entry1.health + ", totalDamage: " + entry1.totaldamg + ") vs" +
								" Player 2 " + entry2.name + " (health: " + entry2.health + 
								", totalDamage: " + entry2.totaldamg + ")");
			roundcount++;
			
			if(entry1.target.equals(entry2.type) || entry1.target.equals("ALL")){
				int tempHealth = entry2.health;
				entry2.health = entry2.health - entry1.damage;
				if(entry2.health <= 0){
					entry2.health = 0;
					System.out.println("Player 2 " + entry2.name + " was killed");
					deathcount2++;
				}
				entry1.totaldamg = entry1.totaldamg + (tempHealth - entry2.health);
			}
			else{
				int tempHealth = entry2.health;
				entry2.health = entry2.health - ((entry1.damage)/2);
				if(entry2.health <= 0){
					entry2.health = 0;
					System.out.println("Player 2 " + entry2.name + " was killed");
					deathcount2++;
				}
				entry1.totaldamg = entry1.totaldamg + (tempHealth - entry2.health);
			}
			if(entry2.target.equals(entry1.type) || entry2.target.equals("ALL")){
				int tempHealth = entry1.health;
				entry1.health = entry1.health - entry2.damage;
				if(entry1.health <= 0){
					entry1.health = 0;
					System.out.println("Player 1 " + entry1.name + " was killed");
					deathcount1++;
				}
				entry2.totaldamg = entry2.totaldamg + (tempHealth - entry1.health);
			}
			else{
				int tempHealth = entry1.health;
				entry1.health = entry1.health - ((entry2.damage)/2);
				if(entry1.health <= 0){
					entry1.health = 0;
					System.out.println("Player 1 " + entry1.name + " was killed");
					deathcount1++;
				}
				entry2.totaldamg = entry2.totaldamg + (tempHealth - entry1.health);
			}
			
			if(deathcount1 == 20){
				System.out.println("Army 1 LOSES");
				System.out.println();
				l2.printWinnerList2();
				break;
			}
			if(deathcount2 == 20){
				System.out.println("Army 2 LOSES");
				System.out.println();
				l.printWinnerList1();
				break;
			}
			
			entry1 = entry1.next;
			entry2 = entry2.next;
			
			while(entry1.health == 0){
				entry1 = entry1.next;
			}
			while(entry2.health == 0){
				entry2 = entry2.next;
			}
			
		}
		
	}
		 
	public static void main(String[] args) {
		
		 LList army1 = new LList();
		 LList army2 = new LList();
		 
		 initArmy1(army1);
		 initArmy2(army2);
		 
		 army1.a1printList();
		 army2.a2printList();
		 startGame(army1, army2);
		 
		}

}

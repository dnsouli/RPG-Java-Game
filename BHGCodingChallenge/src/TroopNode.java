//Author: Danny Nsouli
//BHG Code Challenge
public class TroopNode {
	//All attributes specified for each troop node
	public String name;
	public String type;
	public int damage;
	public int health;
	public String target;
	public int totaldamg;
	public TroopNode next;
  
  public TroopNode(String name, String type, int damage, int health, String target, int totaldamg) {
     this.name = name;
     this.type = type;
     this.damage = damage;
     this.health = health;
     this.target = target;
     this.totaldamg = totaldamg;

  }
  
  
}
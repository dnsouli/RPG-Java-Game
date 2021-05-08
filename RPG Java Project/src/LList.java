//Author: Danny Nsouli
public class LList {

	public TroopNode head;
	public TroopNode tail;

	/*
	 * Simply goes through the list in order to print out the initial troops until
	 * a null entry is encountered meaning the end of the list has been reached
	*/
	public void a1printList(){
		TroopNode entry = head;
	    System.out.println("Army 1 - Initial Troops:");
	    while (entry != null) {
	    	System.out.println(entry.name);
	    	entry = entry.next;
	    }
	    System.out.println();
	  }
	
	/*
	 * (The same concept but for Army 2)
	 * Simply goes through the list in order to print out the initial troops' names until
	 * a null entry is encountered meaning the end of the list has been reached
	*/
	public void a2printList(){
		TroopNode entry = head;
		System.out.println("Army 2 - Initial Troops:");
	    while (entry != null) {
	    	System.out.println(entry.name);
	    	entry = entry.next;
	    }
	    System.out.println();
	  }
	
	/*
	 * Finds the max consecutive string of 1s for an integer in its binary representation; this is done
	 * by ANDing the number with itself (shifted 1 bit to the left); this will in turn reduce the last 1
	 * of any of the number's consecutive strings of 1s until it is reduced to 0; the length variable
	 * keeps track of how many shifts it takes for x to be 0
	*/
	private static int outstandingCheck(int n){
        int length = 0;
        while (n!=0){
          n = (n&(n<< 1));
          length++;
        }
        return length;
	}
	
	/*
	 * Prints out the list of surviving troops with health above 0 in the case that 
	 * Army 1 wins. The outstanding troop member is also identified with a max variable
	 * that is overwritten every time another surviving troop has a better outstanding total damage value
	*/
	public void printWinnerList1(){
		int tcount = 0;
		int max = 0;
		TroopNode entry = head;
		TroopNode outst = null;
		System.out.println("WINNER");
		System.out.println("Army 1 is the winner. Remaining troops: ");
		while (tcount < 20) {
			if(entry.health != 0){
		    System.out.println(entry.name + ", health = " + entry.health + ", totalDamage = " + entry.totaldamg);
		    	if(outstandingCheck(entry.totaldamg) > max){
		    	outst = entry;
		    	max = outstandingCheck(entry.totaldamg);
		    	}
		    entry = entry.next;
		    
			}
			entry = entry.next;
			tcount++;
		}
		System.out.println();
		System.out.println("The most outstanding troop is: ");
		System.out.println(outst.name + ", health = " + outst.health + ", totalDamage = " + outst.totaldamg);
	  }
	
	/*
	 * Prints out the list of surviving troops with health above 0 in the case that 
	 * Army 2 wins. The outstanding troop member is also identified with a max variable
	 * that is overwritten every time another surviving troop has a better outstanding total damage value
	*/
	public void printWinnerList2(){
		int tcount = 0;
		int max = 0;
		TroopNode entry = head;
		TroopNode outst = null;
		System.out.println("WINNER");
		System.out.println("Army 2 is the winner. Remaining troops: ");
		while (tcount < 20) {
			if(entry.health != 0){
		    System.out.println(entry.name + ", health = " + entry.health + ", totalDamage = " + entry.totaldamg);
		    	if(outstandingCheck(entry.totaldamg) > max){
		    	outst = entry;
		    	max = entry.totaldamg;
		    	}
		    entry = entry.next;
		    
			}
			entry = entry.next;
			tcount++;
		}
		System.out.println();
		System.out.println("The most outstanding troop is: ");
		System.out.println(outst.name + ", health = " + outst.health + ", totalDamage = " + outst.totaldamg);
	  }
	
	/*
	 * Setting the last node of the list as the tail so that it
	 * points to the head as its next node; this will make the list circular in order
	 * for it to be an easy cycle to go through when selecting combatants
	*/
	public void setTail(){
		TroopNode entry = head;
	    while (entry.next != null) {
	    	entry = entry.next;
	    }
	    tail = entry;
	    tail.next = head;
	  }
	
	/*
	 * Method used to add the nodes to the initial army lists 
	*/
	  public void addNode(String n, String t, int d, int h, String targ, int td){
	    
	     TroopNode newNode = new TroopNode(n,t,d,h,targ, td);
	     
	   //if head is null then its an empty list so new node is placed at head
	    if (head == null) {			
	        head = newNode; 
	    }
	    
	    else {
	        TroopNode cNode = head;
	        int counter = 1;
	        //otherwise go through the list until the next node after the current is null
            //to reach the end of the list in order to place the new node
	        while (cNode.next != null) {        
	            cNode = cNode.next;
	            counter++;
	        }
	        cNode.next = newNode;
	    }
	     
	  }
}

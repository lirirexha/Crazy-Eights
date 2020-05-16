public class Hand {

	card head = null;
	String name = "";
	public Hand(String x) {
		name = x;
	}
	class card {
		
		card link;
		int suit;
		int value;
		public card(int x, int y, card c) {
			suit = y;
			value = x;
			link = c;
		}
	}
	
	public void addcard(int x, int y) {
		head = new card(x,y,head);
	}
	
	public void printlist() {
		for (card temp = head; temp != null; temp = temp.link) {
			System.out.println(temp.value + " " + temp.suit);
		}
	}
	
	public card getposition(int y) { 
		card temp = head;
		for (int x = 0; x < y ; x++) {
			temp = temp.link;
		}
		return temp;
	}
	
	public int counthand() {
		int count = 0;
		for (card temp = head; temp != null; temp = temp.link) {
			count = count + 1;
		}
		return count;
	}
	
	public void deletecard(int x, int y) {
		card current = head;
		card previous = null;
		boolean found = false;
		while(found == false && current != null) {
			if(x == current.value && y == current.suit) {
				found = true;
			}
			else {
				previous = current;
				current = current.link;
			}
		}
		if (found == true) {
			if (current == head) {
				head = head.link;
			}
			else {
				previous.link = current.link;
			}
		}
	}
}
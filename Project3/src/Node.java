
public class Node {
	private Car item;
	private Node nextNode;
	
	public Node(Car c) {
		item = c;
		nextNode = null;
	}
	
	public Node(Car c, Node n) {
		item = c;
		nextNode = n;
	}
	
	public Node getNextNode(){
		return nextNode;
	}
	
	public void setNextNode(Node n) {
		nextNode = n;
	}
	
	public Car getItem() {
		return item;
	}
	
	public void setItem(Car c){
		item = c;
	}
}

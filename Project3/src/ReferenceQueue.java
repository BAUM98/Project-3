
public class ReferenceQueue {
	private int count;
	private Node head;
	private int maxSize;

	public ReferenceQueue() {
		head = null;
		count = 0;
		maxSize = 50;
	}

	public ReferenceQueue(Car c) {
		Node n = new Node(c);
		head = n;
		count = 1;
		maxSize = 50;
	}
	
	public ReferenceQueue(int max) {
		head = null;
		count = 0;
		maxSize = max;
	}

	public ReferenceQueue(Car c, int max) {
		Node n = new Node(c);
		head = n;
		count = 1;
		maxSize = max;
	}

	public void enqueue(Car c) {
		if (head == null) {
			head = new Node(c);
		}
		else if(count < maxSize){
			Node n = returnLastNode();
			n.setNextNode(new Node(c));
		}
		count++;
	}

	private Node returnLastNode() {
		Node prev = null;
		Node curr = head;
		while (curr != null) {
			prev = curr;
			curr = curr.getNextNode();
		}
		return prev;
	}
	
	public Car peek() {
		return head.getItem();
	}
	
	public Car dequeue() {
		Node n = head;
		head = head.getNextNode();
		count--;
		return n.getItem();
	}
	
	public void dequeueAll() {
		head = null;
		count = 0;
	}
	
	public boolean isEmpty() {
		if(count == 0)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if(count < maxSize)
			return false;
		return true;
	}
	
	public int percentFull() {
		return (100 * count / maxSize);
	}
	
	public void printQueue() {
		Node curr = head;
		for(int i = 0; i < count; i++) {
			System.out.println(curr.getItem().getTimeTraveled() / 60);
			curr = curr.getNextNode();
		}
	}
	
}

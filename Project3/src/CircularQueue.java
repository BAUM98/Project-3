
public class CircularQueue {
	private int maxSize;
	private Car[] queue;
	private int front;
	private int back;
	private int count;
	private boolean lastOpAdd;
	private boolean lastOpRemove;

	public CircularQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = new Car[maxSize];
		front = 0;
		back = 0;
		count = 0;
		lastOpAdd = false;
		lastOpRemove = true;
	}

	public void enqueue(Car temp) {
		if (isFull()) {
			System.out.println("Error: List is full!");
		}
		if (isEmpty()) {
			queue[front] = temp;
			count++;
			lastOpAdd = true;
			lastOpRemove = false;
		} else {
			back = (back + 1) % maxSize;
			queue[back] = temp;
			count++;
			lastOpAdd = true;
			lastOpRemove = false;
		}

	}

	public void dequeue() {
		if (isEmpty())
			System.out.println("Error: List is Empty");
		else {
			front = (front + 1) % maxSize;
			count--;
			lastOpAdd = true; // make into own method later
			lastOpRemove = false;
		}
	}

	public Car peek() {
		System.out.println(front + " " + back);
		return queue[front];
	}

	public void dequeueAll() {
		count = 0;
		front = 0;
		back = 0;
		lastOpAdd = false;
		lastOpRemove = true;
	}

	public boolean isEmpty() {
		if (count == 0) {
			return true;
		} else
			return false;
	}

	public boolean isFull() {
		if (count == maxSize)
			return true;
		else
			return false;
	}

	public void printQueue() {
		if (front != back) {
			for (int i = front; i != back + 1; i++) {
				if (i == maxSize) {
					i = 0;
				}
				System.out.print(queue[i] + " ");
			}
		} else if (isFull()) {
			for (int i = front; i != front - 1; i++) {
				if (i == maxSize) {
					i = 0;
				}
				System.out.print(queue[i] + " ");
			}
		}
	}
	
	public int percentFull() {
		return (100* count / maxSize);
	}

}

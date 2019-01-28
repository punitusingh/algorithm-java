package queue;

public class Queue {
	private int[] a;
	private int head;
	private int tail;
	private int numOfElements = 0;
	public Queue(int size) {
		a = new int[size];
		head = 0;
		tail = a.length-1;
	}
	
	public void enque(int val) {
		if(numOfElements == a.length) {
			System.out.println("queue.Queue is full");
		}else {
			tail = (tail + 1) % a.length;
			a[tail] = val;
			numOfElements++;
		}
	}
	
	public int dequeu() {
		if(numOfElements == 0) {
			System.out.println("queue.Queue is Empty");
			return -1;
		}else {
			int val = a[head];
			head = (head + 1)%a.length; 
			numOfElements--;
			return val;
		}
	}
	
	public boolean isEmpty() {
		if(numOfElements == 0) {
			 return true;
		}else {
			return false;
		}
	}
}

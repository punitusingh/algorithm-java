package stack;

public class Stack {
	private int[] a ;
	private int topOfStack;
	
	public Stack(int size) {
		a = new int[size];
		topOfStack = -1;
	}
	
	public void push(int val) {
		if(topOfStack < a.length-1) {
			a[++topOfStack] = val;
		}else {
			System.out.println("stack.Stack is full !");
		}
	}
	
	public int pop() {
		if(topOfStack <0) {
			System.out.println("stack.Stack is Empty !");
			return -1;
		}else {
			return a[topOfStack--];
		}
	}
	
	public boolean isEmpty() {
		if(topOfStack <0) {
			return true;
		}else {
			return false;
		}
	}
}

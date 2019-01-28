package stack;

public class StackTest {
public static void main(String[] args) {
	Stack s = new Stack(10);
	
	for(int i=0;i<12;i++) {
		s.push(i);
	}
	
	for(int i=0;i<12;i++) {
		System.out.println(s.pop());
	}
}
}

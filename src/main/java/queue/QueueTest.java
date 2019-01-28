package queue;

public class QueueTest {
public static void main(String[] args) {
	Queue q = new Queue(10);
	for(int i=0;i<15;i++) {
		q.enque(i);
	}
	for(int i=0;i<15;i++) {
		System.out.println(q.dequeu());
	}
	
}
}

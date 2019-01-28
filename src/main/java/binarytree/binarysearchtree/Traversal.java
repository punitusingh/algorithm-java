package binarytree.binarysearchtree;
import model.Node;

import java.util.Stack;

public class Traversal {

	
	public static void main(String[] args) {
		//construct binary search tree.
		//			      20
		//		10					30
		//	5		15			25			40
		//		4		17			   35		50
		// 5 and 25 does not have children
		Node n1 = new Node(20);
		Node n2 = new Node(10);
		Node n3 = new Node(30);
		Node n4 = new Node(5);
		Node n5 = new Node(15);
		Node n6 = new Node(25);
		Node n7 = new Node(40);
		Node n8 = new Node(4);
		Node n9 = new Node(17);
		Node n10 = new Node(35);
		Node n11 = new Node(50);
		
		n1.setLeft(n2);
		n1.setRight(n3);
		
		n2.setLeft(n4);
		n2.setRight(n5);
		
		n3.setLeft(n6);
		n3.setRight(n7);
		
		n5.setLeft(n8);
		n5.setRight(n9);
		
		n7.setLeft(n10);
		n7.setRight(n11);
		
		Traversal o = new Traversal();
		//o.preorderR(n1);
		//o.inorderR(n1);
		//o.postorderR(n1);
		//o.preorder(n1);
		//o.inorder(n1);
		o.postorder(n1);
	}
	
	void preorderR(Node n) {
		//visit the node then go to left then go to right
		//20 10 5 15 4 17 30 25 40 35 50
		if(n != null) {
			System.out.println(n.getValue());
			preorderR(n.getLeft());
			preorderR(n.getRight());
		}
	}
	
	void inorderR(Node n) {
		//visit left node then self and then visit the right node.
		//5 10 4 15 17 20 25 30 35 40 50 
		if(n != null) {
			inorderR(n.getLeft());
			System.out.println(n.getValue());
			inorderR(n.getRight());
		}
	}
	
	void postorderR(Node n) {
		//visit left node then right node then the self node.
		//5 4 17 15 10 25 35 50 40 30 20 
		if(n != null) {
			postorderR(n.getLeft());
			postorderR(n.getRight());
			System.out.println(n.getValue());
		}
	}
	
	void preorder(Node n) {
		//push root node on stack. while stack is not empty run the a loop
		//pop element from stack and visit it. then push its right and left child respectively
		//if they are not null.
		//20 10 5 15 4 17 30 25 40 35 50
		if(n != null) {
			Stack<Node> s = new Stack<Node>();
			s.push(n);
			while(!s.isEmpty()) {
				Node curr = s.pop();
				System.out.println(curr.getValue());
				if(curr.getRight() != null) {
				s.push(curr.getRight());
				}
				if(curr.getLeft() != null) {
				s.push(curr.getLeft());
				}
			}
		}
	}
	
	void inorder(Node n) {
		Node curr = n;
		Stack<Node> s = new Stack<Node>();
		while(curr != null || (!s.isEmpty())){
			while(curr !=null) {
				s.push(curr);
				curr = curr.getLeft();
			}
			curr = s.pop();
			System.out.println(curr.getValue());
			
			curr = curr.getRight();
		}
	}
	
	void postorder(Node n) {
		Node prev = null;
		Stack<Node> s = new Stack<Node>();
		s.push(n);
		while(!s.isEmpty()) {
			Node curr = s.peek();
			
			if(prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
				if(curr.getLeft() != null) {
					s.push(curr.getLeft());
				}else if(curr.getRight() != null) {
					s.push(curr.getRight());
				}else {
					curr = s.pop();
					System.out.println(curr.getValue());
				}
			}else if(curr.getLeft() == prev) {
				if(curr.getRight() != null) {
					s.push(curr.getRight());
				}
			}else if(curr.getRight() == prev) {
				curr = s.pop();
				System.out.println(curr.getValue());
			}
		
			prev = curr;
		}
		
	}
	
	
}

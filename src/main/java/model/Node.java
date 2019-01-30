package model;

public class Node {
public int value = -1;
public Node left = null;
public Node right = null;
public Node(int v) {
	value = v;
}

public Node getLeft() {
	return left;
}
public void setLeft(Node n) {
	left = n;
}

public Node getRight() {
	return right;
}

public void setRight(Node n) {
	right = n;
}

public int getValue() {
	return value;
}
public void setValue(int v) {
	value = v;
}
}

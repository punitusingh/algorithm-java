package model;

public class Node {
int value = -1;
Node left = null;
Node right = null;
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

package binarytree.binarysearchtree.preorder;


//construct binary search tree.
//			      20
//		10					30

//root -> left tree -> right tree

//output : 20, 10 , 30

// stack : [20] add root
//        while stack not empty pop, and add right children, then left children, as we need to pop left first
//          -> pop 20 [] -> [30, 10]
//          -> pop 10 [30]
//          -> pop 30 []
//
//

import model.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreOrderIterative {
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root == null){ return list; }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.value);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return list;
    }
}

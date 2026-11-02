package com.interview.tree;

import com.interview.linkedlist.Node;

import java.util.Deque;
import java.util.LinkedList;

public class IsBST {

    public boolean isBST(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data > max){
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public boolean isBSTIt(Node root){
        if(root == null){
            return true;
        }

        Deque<Node> stack = new LinkedList<>();
        Node node = root;
        int prev = Integer.MIN_VALUE;
        int current;
        while(true){
            if(node != null){
                stack.addFirst(node);
                node = node.left;
            } else {
                if(stack.isEmpty()){
                    break;
                }
                node = stack.peekFirst();
                current = node.data;
                if(current < prev){
                 return false;
                }
                prev = current;
                node = node.right;
            }
        }
        return false;
    }
}

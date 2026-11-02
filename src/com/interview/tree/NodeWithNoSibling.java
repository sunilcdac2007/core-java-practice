package com.interview.tree;

import com.interview.linkedlist.Node;

public class NodeWithNoSibling {


    public void printNodes(Node root){

        if(root == null) return;
        if(root.left == null || root.right == null){
            if(root.left != null) System.out.println(root.left.data);
            if(root.right != null) System.out.println(root.right.data);
        }

        printNodes(root.left);
        printNodes(root.right);
    }
}

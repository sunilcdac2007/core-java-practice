package com.interview.tree;

import com.interview.linkedlist.Node;

public class SameTree {

    public boolean isSameTree(Node root1, Node root2){

        if(root1 == null && root2 == null) return true;

        if(root1 == null || root2 == null) return false;

        return root1.data == root2.data &&
                isSameTree(root1.left, root2.left) &&
                isSameTree(root1.right, root2.right);
    }
}

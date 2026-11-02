package com.interview.tree;

import com.interview.linkedlist.Node;

public class NodeAtDistanceK {

    private void findInChild(Node root, int k){
       if(root == null) return;
       if(k == 0) System.out.println(root.data);
       findInChild(root.left, k-1);
       findInChild(root.right, k-1);
    }

}

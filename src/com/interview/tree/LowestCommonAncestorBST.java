package com.interview.tree;

import com.interview.linkedlist.Node;

public class LowestCommonAncestorBST {

    public Node lca(Node root, int n1, int n2){
       if(root.data > Math.max(n1,n2)){
           return lca(root.left, n1,n2);
       } else if (root.data < Math.min(n1,n2)){
           return lca(root.right, n1, n2);
       } else {
           return root;
       }
    }

}

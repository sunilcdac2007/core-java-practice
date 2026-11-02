package com.interview.tree;

import com.interview.linkedlist.Node;

public class ArbitaryTreeToChildSumTree {


    public int childSumTree(Node root){
        if(root == null) return 0;

        if(root.left == null && root.right == null){
            return root.data;
        }

        int sum1 = childSumTree(root.right);
        int sum2 = childSumTree(root.left);

        if(root.data < sum1 + sum2){
            root.data = sum1 + sum2;
        } else {
            incrementChile(root, root.data-sum1-sum2);
        }

        return root.data;
    }

    private void incrementChile(Node root, int incr) {
     if(root == null || (root.left == null && root.right == null)){
         return;
     }
     if(root.left != null){
         root.left.data = root.left.data + incr;
         incrementChile(root.left,incr);
     } else {
         root.right.data = root.right.data + incr;
         incrementChile(root.right,incr);
     }

    }
}

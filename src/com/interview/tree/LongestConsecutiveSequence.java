package com.interview.tree;

import com.interview.linkedlist.Node;

public class LongestConsecutiveSequence {

    int max =0;
    public int longest(Node root){

       if(root == null) return 0;

       longestSeqUtil(root, root.data-1, max);
       return max;
    }

    private void longestSeqUtil(Node root, int prevData, int current) {
       if(root == null) return ;

       if(prevData +1 == root.data){
           current = current +1;
       } else {
           current = 1;
       }
       max = Math.max(max, current);
       longestSeqUtil(root.left, root.data, current);
       longestSeqUtil(root.right, root.data, current);
    }


}

package com.interview.tree;

import com.interview.linkedlist.Node;

public class DiameterOfTree {

    class Height {
        int height;
    }

    public int diameter(Node root){
        Height height = new Height();
        return diameter(root, height);
    }

    private int diameter(Node root, Height height) {
      if(root == null) return 0;
      Height left = new Height();
      Height right = new Height();
      int dial = diameter(root.left, left);
      int diar = diameter(root.right, right);
      height.height = Math.max(left.height, right.height) +1;
      return Math.max(Math.max(dial, diar), (left.height+right.height +1));
    }

}

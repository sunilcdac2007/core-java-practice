package com.interview.tree;

import com.interview.linkedlist.Node;

import java.util.List;

public class RootToLeafToSum {

    public boolean printPath(Node root, int sum, List<Node> path){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(root.data == sum){
                path.add(root);
                return true;
            } else {
                return false;
            }
        }
        if(printPath(root.left, sum-root.data, path) || printPath(root.right, sum - root.data, path)){
            path.add(root);
            return true;
        }
      return false;
    }

}

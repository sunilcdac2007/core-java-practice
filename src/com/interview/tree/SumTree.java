package com.interview.tree;

import com.interview.linkedlist.Node;

public class SumTree {

    class Count{
        int sum;
    }

    public boolean isSumTree(Node root, Count countSum){
        if(root==null) return true;
        if(root.left == null && root.right == null){
            countSum.sum = root.data;
            return true;
        }
        Count left = new Count();
        Count right = new Count();
        boolean isLeft = isSumTree(root.left, left);
        boolean isRight = isSumTree(root.right, right);
        countSum.sum = left.sum + right.sum + root.data;
        return isLeft && isRight && root.data == left.sum + right.sum;
    }
}

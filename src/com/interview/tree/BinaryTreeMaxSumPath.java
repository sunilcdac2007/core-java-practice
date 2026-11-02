package com.interview.tree;

import com.interview.linkedlist.Node;

public class BinaryTreeMaxSumPath {
    static void main() {
        BinaryTreeMaxSumPath maxSumPath = new BinaryTreeMaxSumPath();
        int arr[] = {4,2,6,1,5,7,9};
        Node root = Tree.creatTree(arr);
        maxSumPath.maxSumPath(root);
        System.out.println(MAX_SUM);
    }
    static int MAX_SUM =0;
    public int  maxSumPath(Node root){
        if(root == null) return 0;
        int left = maxSumPath(root.left);
        int right = maxSumPath(root.right);
        MAX_SUM = Math.max(MAX_SUM, root.data + Math.max(left,right));
        return root.data + Math.max(left,right);
    }
}

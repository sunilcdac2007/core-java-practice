package com.interview.tree;

import com.interview.linkedlist.Node;

public class ConstructTreeFromInorderTraversalRootGreaterThanChild {

    static void main() {
        int[] inOrder = {9,15,25,6,18,-1,3,-3};
       Node root = createTree(inOrder, 0, inOrder.length-1);
        System.out.println(root);
    }
public static Node createTree(int[] inOrder, int low, int high){
    if(low > high){
        return null;
    }
    int index;
    int maxIndex = low;
    for(index=low; index <= high; index++){
        if(inOrder[maxIndex] > inOrder[index]){
            maxIndex= index;
        }
    }
    Node root = new Node(inOrder[maxIndex]);
    root.left = createTree(inOrder, low, maxIndex-1);
    root.right = createTree(inOrder, maxIndex+1, high);
    return root;
}

}

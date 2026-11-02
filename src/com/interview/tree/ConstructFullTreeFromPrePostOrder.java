package com.interview.tree;

import com.interview.linkedlist.Node;

public class ConstructFullTreeFromPrePostOrder {

    static void main() {
        int[] preOrder = {5,3,2,4,9,7,11};
        int[] postOrder = {2,4,3,7,11,9,5};
        Node root = buildFullTree(preOrder, postOrder, 0, postOrder.length-2,0);
        System.out.println(root);
    }

    private static Node buildFullTree(int[] preOrder, int[] postOrder, int min, int max, int index) {
       if(min > max || index >= postOrder.length-1){
           return new Node(preOrder[index]);
       }
       Node root = new Node(preOrder[index]);
       int ind=0;
       for( ind=min; ind < max; ind++){
           if(preOrder[index+1] == postOrder[ind]){
               break;
           }
       }
       root.left = buildFullTree(preOrder, postOrder, min , ind-1, index+1);
       root.right = buildFullTree(preOrder, postOrder, ind+1, max-1, index+ind - min + 2);
       return root;
    }
}

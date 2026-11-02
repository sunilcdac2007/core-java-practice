package com.interview.tree;

import com.interview.linkedlist.Node;


public class ConstructBSTFromPreOrder {

   static class Index{
        int index;
    }
    static void main() {
        int arr[] ={5,3,2,4,9,7,11};
      Node bst =  construct(arr, Integer.MIN_VALUE, Integer.MAX_VALUE, new Index());
        System.out.println(bst);
    }

    private static Node construct(int[] preOrder, int minValue, int maxValue, Index index) {
    if(index.index >= preOrder.length){
        return null;
    }
    if(preOrder[index.index] < minValue || preOrder[index.index] > maxValue ){
        return null;
    }

    Node root = new Node(preOrder[index.index]);
    index.index++;
    root.left = construct(preOrder, minValue, root.data, index);
    root.right = construct(preOrder, root.data, maxValue, index);
    return root;
    }
}

package com.interview.tree;

import com.interview.linkedlist.Node;

public class ConstructBSTFromPostOrder {
    static void main() {

        int[] postOrder = {2,4,3,7,11,9,5};
        ConstructBSTFromPreOrder.Index index = new ConstructBSTFromPreOrder.Index();
        index.index = postOrder.length-1;
       Node bst = construct(postOrder, Integer.MIN_VALUE, Integer.MAX_VALUE, index);
        System.out.println(bst);
    }

    private static Node construct(int[] postOrder, int minValue, int maxValue, ConstructBSTFromPreOrder.Index index) {

        if( index.index < 0 ){
            return null;
        }
        if(postOrder[index.index] < minValue || postOrder[index.index] >= maxValue){
            return null;
        }
        Node root = new Node(postOrder[index.index]);
        index.index--;
        root.right = construct(postOrder, root.data, maxValue, index);
        root.left = construct(postOrder, minValue, root.data, index);

        return root;
    }
}

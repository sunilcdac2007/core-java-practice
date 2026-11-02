package com.interview.tree;

import com.interview.linkedlist.Node;

public class ConstructBSTFromInOrder {

    static void main() {
        int arr[] = {2,3,4,5,7,9,11};
        Node bst = buildBST(arr, 0, arr.length-1);
        System.out.println(bst);
    }

    private static Node buildBST(int[] inorder, int startIndex, int endIndex) {
        if(startIndex > endIndex){
            return null;
        }
        int middle = (startIndex + endIndex)/2;
        Node root = new Node(inorder[middle]);
        root.left = buildBST(inorder, startIndex, middle-1);
        root.right = buildBST(inorder, middle+1, endIndex);
        return root;
    }
}

package com.interview.tree;

import com.interview.linkedlist.Node;

public class ConstructTreeFromInOrderPreOrder {

   static int index=0;
    static void main() {
        int[] preOrder = {5,3,2,4,9,7,11};
        //int[] postOrder = {2,4,3,7,11,9,5};
        int[] inorder = {2,3,4,5,7,9,11};
        System.out.println(buildTree(preOrder,inorder,0, preOrder.length-1));

    }

    public static Node buildTree( int[] preOrder, int[] inOrder, int start, int end){
       if(start> end){
           return null;
       }
       int ind=0;
       for(ind=start; ind< end ; ind++){
           if(preOrder[index]  == inOrder[ind]){
               break;
           }
       }
       Node root = new Node(preOrder[index]);
       index++;

       root.left = buildTree(preOrder, inOrder, start, ind -1);
       root.right = buildTree(preOrder, inOrder, ind+1, end);
       return root;

    }
}

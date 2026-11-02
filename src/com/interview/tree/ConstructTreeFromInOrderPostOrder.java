package com.interview.tree;

import com.interview.linkedlist.Node;

public class ConstructTreeFromInOrderPostOrder {
    static void main() {
        int[] postOrder = {2,4,3,7,11,9,5};
        int[] inorder = {2,3,4,5,7,9,11};
        Node root = buildTree(inorder, postOrder, 0, inorder.length - 1, postOrder.length - 1);
        System.out.println(root);
    }
    public static Node buildTree(int[] inOrder, int[] postOrder, int start, int end, int index){

      if(start > end || index < 0) return  null;

      int ind=0;
      for(ind = start; ind<= end; ind++){
          if(postOrder[index] == inOrder[ind]){
              break;
          }
      }

      Node root = new Node(postOrder[index]);
      index--;
      root.left = buildTree(inOrder, postOrder, start, ind-1, index - (end-ind+1));
      root.right = buildTree(inOrder, postOrder, ind+1, end, index-1);
      return root;

    }

}

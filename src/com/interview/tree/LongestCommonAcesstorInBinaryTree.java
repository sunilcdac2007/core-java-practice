package com.interview.tree;

import com.interview.linkedlist.Node;

public class LongestCommonAcesstorInBinaryTree {

    static void main() {
        int arr[] = {4,2,6,1,5,7,9};
        Node root = Tree.creatTree(arr);
        System.out.println(root);

       Node root1 = lca(root, 1,5);
        System.out.println(root1);
    }
    public static  Node lca(Node root, int n1, int n2){
      if(root == null) return null;

      if(root.data == n1 || root.data == n2){
          return root;
      }

      Node left = lca(root.left, n1,n2);
      Node right = lca(root.right, n1, n2);
      if(left != null && right != null){
          return root;
      }
      return left !=null? left: right;
    }
}

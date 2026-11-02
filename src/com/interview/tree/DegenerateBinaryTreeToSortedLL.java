package com.interview.tree;

import com.interview.linkedlist.Node;

public class DegenerateBinaryTreeToSortedLL {

      public Node degenerat(Node root){

       if(root == null) return null;

       Node left = root.left;
       Node right = root.right;
       root.left = null;
       root.right = null;
       left = degenerat(left);
       right = degenerat(right);
       left = merge(left, root);
       return merge(left, right);

      }

      private Node merge(Node root1, Node root2){

          if(root1 == null) return root2;
          if(root2 == null) return root1;

          if(root1.data <= root2.data){
              root1 = merge(root1.right, root2);
              return root1;
          } else {

              root2 = merge(root1, root2.right);
              return root2;
          }


      }

}

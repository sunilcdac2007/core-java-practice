package com.interview.tree;

import com.interview.linkedlist.Node;


public class ConnectNodesAtSameLevel {

    static void main() {
        int arr[] = {4,2,6,1,5,7,9};
        Node root = Tree.creatTree(arr);
        connect(root);
        System.out.println(root);
    }
    public static void connect(Node root){
       if(root == null) return ;

       Node firstNode= root;
       Node previousNode = null;

       while(firstNode != null){
           root = firstNode;
           firstNode=null;
           previousNode=null;
           while(root != null){

               if(root.left != null){
                   if(previousNode == null){
                       previousNode= root.left;
                   }

                   if(previousNode != null){
                       previousNode.next = root.left;
                   }
                   previousNode = root.left;
               }

               if(root.right != null){

                   if(root.right != null){
                       if(previousNode == null){
                           previousNode = root.right;
                       }
                       if(previousNode != null){
                           previousNode.next = root.right;
                       }
                       previousNode = root.right;
                   }
                   root= root.next;
               }

           }

       }
    }

}

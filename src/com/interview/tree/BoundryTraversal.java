package com.interview.tree;

import com.interview.linkedlist.Node;

public class BoundryTraversal {

    static void main() {
        int arr[] = {4,2,6,1,5,7,9};
        Node root = Tree.creatTree(arr);
        BoundryTraversal boundryTraversal = new BoundryTraversal();
    //    boundryTraversal.printRight(root);
    //    boundryTraversal.printLeaves(root);
        boundryTraversal.printLeft(root);
    }
    public void printRight(Node root){

        if(root==null || ( root.left == null && root.right == null)){
            return;
        }
        System.out.println(root.data);
        if(root.right != null){
            printRight(root.right);
        } else {
            printRight(root.left);
        }
    }
    public void printLeft(Node root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        if(root.left != null){
            printLeft(root.left);
        }else {
            printLeft(root.right);
        }
        System.out.println(root.data);
    }
    public void printLeaves(Node root){
        if(root == null){
            return;
        }
        if(root.left ==null && root.right == null){
            System.out.println(root.data);
        }
        printLeaves(root.right);
        printLeaves(root.left);
    }
}

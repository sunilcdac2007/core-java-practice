package com.interview.tree;

import com.interview.linkedlist.Node;
import com.interview.linkedlist.RefNode;

public class BinaryTreeToDoubleLinkList {

    static void main() {
        int arr[] = {4,2,6,1,5,7,9};
        Node root = Tree.creatTree(arr);

        BinaryTreeToDoubleLinkList binaryTreeToDoubleLinkList = new BinaryTreeToDoubleLinkList();

        binaryTreeToDoubleLinkList.toDoubleLL(root, new RefNode());
        System.out.println(root);
    }
    public void toDoubleLL(Node root, RefNode refNode){
        if(root == null) return;
        toDoubleLL(root.left, refNode);
        if(refNode.node != null){
            refNode.node.next = root;
            root.before =refNode.node;
            refNode.node = root;

        } else {
           refNode.node = root;
        }
        toDoubleLL(root.right, refNode);
    }
}

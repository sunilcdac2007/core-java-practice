package com.interview.tree;

import com.interview.linkedlist.Node;

public class  AddGreaterValueNodeAtEveryNode {

    static void main() {
        AddGreaterValueNodeAtEveryNode add = new AddGreaterValueNodeAtEveryNode();
        int arr[] = {23,65,45,19,20,25,5};
        Node tree = Tree.creatTree(arr);
        System.out.println(tree);
        add.addGreaterValue(tree,0);
        System.out.println(tree);
    }

    private void addGreaterValue(Node head, int refVal) {
        if(head == null){
            return;
        }
        addGreaterValue(head.right, refVal);
        head.data = head.data + refVal;
        refVal = head.data;
        addGreaterValue(head.left, refVal);
    }

}

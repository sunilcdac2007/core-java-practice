package com.interview.tree;

import com.interview.linkedlist.Node;

public class Tree {

    public static Node creatTree(int[] arr){
        if(arr == null) return null;
        Node head=null;
        for(int i=0; i < arr.length; i++){
            head = addNodeInTree(arr[i], head);
        }
        return head;
    }

    public static Node addNodeInTree(int data, Node head) {

        Node temp = head;
        Node n = new Node(data);
        if(head == null){
           head = n;
           return head;
        }
        Node prev = null;
        while(head != null){
            prev=head;
            if(head.data < data){
                head = head.right;
            }else {
                head = head.left;
            }
        }
        if(prev.data < data){
            prev.right = n;
        }else {
            prev.left = n;
        }
        return temp;
    }
}

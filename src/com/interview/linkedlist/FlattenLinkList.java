package com.interview.linkedlist;

public class FlattenLinkList {

    static void main() {

    }

    public void flatten(Node node){
        if(node == null){
            return ;
        }
        Node tailNode = getTail(node);
        Node head = node;
        while(head.next != null){
            if(head.child != null){
                tailNode.next = head.child;
                tailNode = getTail(head);
                head.child = null;
            }
            head = head.next;
        }
    }

    public  Node getTail(Node node){
        if(node == null) return null;
        while(node.next != null){
            node=node.next;
        }
        return node;
    }
}

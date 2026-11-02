package com.interview.linkedlist;

public class ReversKNode {

    static void main() {
        Node node = Node.createNode(6);
        Node reverseNode = reverseNode(node, 3);
        System.out.println(reverseNode);
    }


    public static Node  reverseNode(Node head, int k){

        Node previous = null;
        Node current = head;
        Node next = null;
        int i=0;
        while(current != null && i <= k){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            i++;
        }
        Node node = previous;
        if(current != null){
            while(previous.next != null){
                previous=previous.next;
            }
            previous.next = current;
        }
        return node;

    }

}

package com.interview.linkedlist;

public class ReversLinkedList {

   public static  Node reverse(Node node){
        Node previous = null;
        Node curr = node;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        return previous;
    }

    public static Node  reverseRecursive(Node node){
       if(node == null || node.next == null){
           return node;
       }
       Node curr = reverseRecursive(node.next);
       node.next.next = node;
       node.next = null;
       return curr;
    }


    static void main() {
       Node head = Node.createNode(5);
        //Node node = reverse(head);
        Node node = reverseRecursive(head);
        System.out.println(node);
    }
}

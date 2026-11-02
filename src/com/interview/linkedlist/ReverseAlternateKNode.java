package com.interview.linkedlist;

public class ReverseAlternateKNode {

    public static Node reverse(Node head, int k, boolean revFlag){
        if(k<=1) return head;
        if(head == null) return null;
        if(revFlag){

            int i=0;
            Node previous = null;
            Node current = head;
            Node next = null;
            while(current != null && i < k){

                next = current.next;
                current.next = previous;
                previous=current;
                current = next;
                i++;
            }
            head.next = reverse(current,k,!revFlag);
            head = previous;

        } else {
            int i=0;
            Node temp = head;
            while(i < k && head != null){
                head = head.next;
                i++;
            }
            if(head != null){
                head.next = reverse(head.next, k, !revFlag);
            }
            head = temp;
        }
        return head;

    }
}

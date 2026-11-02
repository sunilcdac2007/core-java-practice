package com.interview.linkedlist;

public class DeleteNAfterNNode {

    public static void deleteNode(Node node, int n , int m){
        Node head = node;
        while(head != null) {
            for (int i = 0; i < m && head != null; i++) {

                head = head.next;
            }
            if (head == null)
                return;

            Node temp = head;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }
            head.next = temp;
        }
    }

    static void main() {
       Node node= Node.createNode(20);
       deleteNode(node,2, 3);

        System.out.println(node);

    }

}

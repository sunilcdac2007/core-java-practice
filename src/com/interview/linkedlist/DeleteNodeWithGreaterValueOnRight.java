package com.interview.linkedlist;

public class DeleteNodeWithGreaterValueOnRight {

    static void main() {
        Node node = new Node(12);
       node= node.addNode(15,node);
        node.addNode(10,node);
        node.addNode(11,node);
        node.addNode(5,node);
        node.addNode(6,node);
        node.addNode(2,node);
        node.addNode(3,node);
        deleteNodes(node);
        System.out.println(node);


    }

    static int maxFound = Integer.MIN_VALUE;

    public static Node deleteNodes(Node head){
        if(head == null){
            return null;
        }
        Node nextNode = deleteNodes(head.next);
        if(head.data > maxFound){
            maxFound = head.data;
        }
        if(maxFound > head.data){
            return nextNode;
        }
        head.next = nextNode;
        return head;
    }
}

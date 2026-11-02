package com.interview.linkedlist;

public class InsertionSortLinkedList {


    public Node insert(Node head, Node curr){

        if(head ==null){
            head = curr;
            return head;
        }

        Node previousNode = null;
        Node start = head;
        while(start != null && curr.data >= head.data){
            previousNode = start;
            start = start.next;
        }
        if(previousNode == null){
            curr.next = head;
            head = curr;
        }else {
            previousNode.next = curr;
            curr.next = start;
        }
        return head;
    }


    public void sort(Node node){

        Node previousNode = null;
        Node currentNode = node;
        Node result=null;
        while(currentNode != null){
            previousNode=currentNode;
            currentNode=currentNode.next;
            previousNode.next = null;
            insert(result, previousNode);
        }
    }

}

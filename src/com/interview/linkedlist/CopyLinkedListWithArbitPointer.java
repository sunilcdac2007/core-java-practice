package com.interview.linkedlist;

public class CopyLinkedListWithArbitPointer {

    static void main() {
        Node n1 = Node.createArbitatoryNode();

        Node.createNode(5);
        CopyLinkedListWithArbitPointer linked = new CopyLinkedListWithArbitPointer();
        Node l =linked.copyLinkedList(n1);
        System.out.println(l);
    }


    public Node copyLinkedList(Node node){

        if(node == null){
            return null;
        }

        Node currentNode = node;
        Node newNode=null;
        while(currentNode != null) {
            newNode = new Node(currentNode.data);
            newNode.next = currentNode.next;
            newNode.arbitPointer = currentNode.arbitPointer;
            currentNode.next = newNode;
            currentNode = newNode.next;

        }
        currentNode = node;

        while(currentNode != null){
            Node copyNode = currentNode.next;
            if(copyNode.arbitPointer != null){
                copyNode.arbitPointer = copyNode.arbitPointer.next;
            }
            currentNode = currentNode.next.next;
        }

        currentNode = node;
        Node dummy = new Node(0);
        Node newCurrent = dummy;
        while(currentNode != null){
            newCurrent.next = currentNode.next;
            newCurrent = newCurrent.next;
            currentNode.next = currentNode.next.next;
            currentNode=currentNode.next;
        }

        return dummy.next;
    }
}

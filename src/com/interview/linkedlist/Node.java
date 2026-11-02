package com.interview.linkedlist;

public class Node {

   public  int data;
   public Node next;
   public Node arbitPointer;
   public Node before;
   public Node child;

   public Node left;
   public Node right;
    public Node(int data, Node next, Node arbitPointer) {
        this.data = data;
        this.next = next;
        this.arbitPointer = arbitPointer;
    }

    public Node(int data) {
        this.data = data;
    }

    public static Node createDummyNode(){

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next=n2;
        Node n3 = new Node(3);
        n2.next=n3;
        Node n4 = new Node(4);
        n3.next=n4;
        Node n5 = new Node(5);
        n4.next=n5;
        return n1;
    }

    public static Node createArbitatoryNode(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next=n2;
        Node n3 = new Node(3);
        n2.next=n3;
        Node n4 = new Node(4);
        n3.next=n4;
        Node n5 = new Node(5);
        n4.next=n5;
        n1.arbitPointer=n3;
        n2.arbitPointer=n5;
        n3.arbitPointer=n1;
        n4.arbitPointer=n2;
        n5.arbitPointer=n4;
        return n1;
    }

    public static Node creatPailndrom(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next=n2;
        Node n3 = new Node(3);
        n2.next=n3;
        Node n4 = new Node(2);
        n3.next=n4;
        Node n5 = new Node(1);
        n4.next=n5;
        return n1;
    }
    public Node addNode(int data, Node node){
        Node head = node;
        if(head ==null) {
            head = new Node(data);
            return head;
        }
        while(head.next != null){
            head= head.next;
        }
        head.next = new Node(data);
        return node;
    }
    public static Node createNode(int n){
        Node node=new Node(0);
        Node head = node;
        for(int i=0; i < n; i++){
            Node temp = new Node(i);
            head.next = temp;
            head = temp;

        }
        return node;
    }

}

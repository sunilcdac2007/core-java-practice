package com.interview.linkedlist;

public class LinkedListPailendrom {


    public static  boolean isPalindrom(RefNode refNode, Node head){

        if(head == null){
            return true;
        }

        boolean is = isPalindrom(refNode, head.next);
        is = is && refNode.node.data == head.data;
        refNode.node= refNode.node.next;
        return is;
    }

    static void main() {
        Node n1 = Node.creatPailndrom();
        RefNode node = new RefNode();
        node.node = n1;
        boolean is = isPalindrom(node,n1);
        System.out.println(is);
    }
}

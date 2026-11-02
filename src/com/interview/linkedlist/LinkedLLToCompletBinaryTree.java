package com.interview.linkedlist;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedLLToCompletBinaryTree {

    static void main() {
     Node head =   Node.createNode(6);
      convertLLToCBT(head);
        System.out.println(head);
    }

    public static void convertLLToCBT(Node head){

        if(head == null){
            return ;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        head = head.next;
        while(head != null){
            Node node = queue.poll();
            node.left = head;
            head = head.next;
            if(head != null){
                node.right = head;
                head = head.next;
                node.left.next = null;
                node.right.next = null;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

    }
}

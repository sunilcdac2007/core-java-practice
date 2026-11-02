package com.interview.linkedlist;

public class LoopInLinkedList {

    public static boolean isLoopExist(Node node) {
     if(node == null || node.next == null) return false;
     Node slow = node;
     Node fast = node.next;
     while(fast != null){
      if(fast == slow || fast.next == slow) return false;

     }
     return false;
    }
}

package com.interview.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int MAX_SIZE ;
    int currentSize = 0;
    Map<Integer, Node> cache = new HashMap<>();
    Node head;
    Node tail;

    LRUCache(int size){
        this.MAX_SIZE = size;
    }

    void used(int data){

        Node node = cache.get(data);
        if(node != null){
            if(node != head){
                deleteFromCache(data);
                node.next=head;
                head.before=node;
                head=node;
                cache.putIfAbsent(data, node);
            }
        }else{
            addIntoCache(data);
        }
    }

    void addIntoCache(int data){
        if(head == null && currentSize ==0){
            Node node = new Node(data);
            cache.putIfAbsent(data, node);
            head = node;
            tail=node;
            currentSize++;
            return;
        }

        if(currentSize == MAX_SIZE){
            Node oldTail = tail;
            tail = tail.before;
            oldTail.before=null;
            tail.next = null;
            cache.remove(oldTail.data);
            return;
        }


        Node node = new Node(data);
        node.next=head;
        assert head != null;
        head.before=node;
        head = node;

        cache.putIfAbsent(data,node);
    }

    void deleteFromCache(int data){
        Node node = cache.get(data);
        if(node == null){
            return;
        }
        cache.remove(data);
        if(data == head.data){
            Node nextHead = head.next;
            head.next = null;
            head = nextHead;
            nextHead.before=null;
            currentSize--;
        }else if(data == tail.data){
            Node nextTail = tail.before;
            nextTail.before=null;
            nextTail.next=null;
            tail = nextTail;
            currentSize--;
        } else{
            Node befor= node.before;
            Node next = node.next;
            node.before=null;
            node.next=null;
            befor.next = next;
            next.before=befor;
        }
    }
}

package com.interview.linkedlist;

public class StackWithLLMidleOperation {

    Node head = null;
    Node middle = null;
    int size=0;

    public  void push(int data){

        if (head == null) {

            head = new Node(data);
            middle = head;
            size++;
            return;
        }
        size++;
        Node node = new Node(data);
        node.next = head;
        head.before = node;
        head = node;
        if(size%2 == 0){
            middle = middle.before;
        }
    }

    public int pop(){
        if(size == 0){
            throw new IllegalArgumentException();
        }
        size --;
        if(size%2 != 0 || size ==0){
            middle = middle.next;
        }
        int data = head.data;
        head = head.next;
        head.before=null;
        return data ;
    }

    public int deleteMiddle(){

        if(size == 0){
            throw new IllegalArgumentException();
        }
        size--;
        if(middle == head){
            int data = middle.data;
            middle = middle.next;
            head = head.next;
            if(head != null){
                head.before = null;
            }
            return data;
        }
        if (size % 2 == 0) {

            int data = middle.data;
            Node next = middle.next;
            middle = middle.before;
            middle.next = next;
            if(next != null){
                next.before = middle;
            }
            return data;
        } else {
            int data = middle.data;
            Node before = middle.before;
            middle = middle.next;
            middle.before = before;
            if(before != null){
                before.next = middle;
            }
            return data;
        }
    }


    static void main() {

        StackWithLLMidleOperation stack = new StackWithLLMidleOperation();
        stack.push(1);
        stack.push(2);;
        stack.push(3);
        stack.push(4);
        System.out.println(stack.head);
        System.out.println(stack.middle);
    }
}

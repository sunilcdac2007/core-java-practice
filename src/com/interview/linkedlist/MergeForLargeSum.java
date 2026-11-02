package com.interview.linkedlist;

public class MergeForLargeSum {


    Node maxSumChain(Node head1, Node head2){

        if(head1 == null) return head2;
        if(head2 == null) return head1;

        Node current1= head1;
        Node current2 = head2;
        int sum1 = 0;
        int sum2 = 0;

        Node result = null;
        Node prev = null;
        while(current1 != null && current2 != null){
            // we need to write logic here
            if(current1.data == current2.data){
            sum1 = sum1 + current1.data;
            sum2 = sum2 + current2.data;
            if(sum1 <= sum2){
                if(result == null){
                    result = head2;
                    prev = current2;
                }else {
                    prev.next = head2.next;
                    prev = current2;
                }
            } else {
                if(result == null){
                    result = head1;
                    prev = current1;
                } else {
                    prev.next = head1.next;
                    prev=current1;
                }
            }
            head1 = current1;
            head2 = current2;
            sum1=0;
            sum2 = 0;
            current1 = current1.next;
            current2 = current2.next;
            }else if(current1.data < current2.data){
                 sum1 = sum1 + current1.data;
                 current1=current1.next;
            }else {
                sum2 = sum2 + current2.data;
                current2 = current2.next;
            }
        }

        while(current1 != null){
            sum1 = sum1 + current1.data;
            current1 = current1.next;
        }

        while(current2 != null){

            sum2 = sum2 + current2.data;
            current2 = current2.next;
        }

        if(result != null){
            if(sum1 <= sum2){
                prev.next = head2.next;
            } else {
                prev.next = head1.next;
            }
        }else {
            if(sum1 <=sum2){
                result = head2;
            } else{
                result = head1;
            }
        }

        return result;
    }


}

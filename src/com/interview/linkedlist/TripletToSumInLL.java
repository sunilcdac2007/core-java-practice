package com.interview.linkedlist;

public class TripletToSumInLL {

    public void printTriplate(Node n1, Node n2, Node n3, int sum){

        while(n1 != null){
            int data1 = n1.data;
            int newSum = sum-data1;
            while(n2 != null && n3 != null){

                if(n2.data + n2.data == newSum){
                    System.out.println(" this is matched ");
                } else if (n2.data + n3.data > newSum){
                    
                }
            }
        }
    }
}

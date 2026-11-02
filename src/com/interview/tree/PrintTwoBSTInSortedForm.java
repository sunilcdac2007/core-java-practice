package com.interview.tree;

import com.interview.linkedlist.Node;

import java.util.Deque;
import java.util.LinkedList;

public class PrintTwoBSTInSortedForm {

    public void print(Node root1, Node root2){
        Deque<Node> s1 = new LinkedList<>();
        Deque<Node> s2 = new LinkedList<>();
        while(true){
            if(root1 != null){
                s1.add(root1);
                root1= root1.left;
                continue;
            }

            if(root2 != null){
                s2.add(root2);
                root2 = root2.left;
                continue;
            }
            if(!s1.isEmpty()){
                root1 = s1.peekFirst();
            }
            if(!s2.isEmpty()){
                root2 = s2.peekFirst();
            }

            if(root1 != null && root2 != null){

                if(root1.data <= root2.data){
                    System.out.println(root1.data);
                    root1 = s1.pollFirst();
                    root1 = root1.right;
                    root2 = null;
                } else {
                    System.out.println(root2.data);
                    root2=s2.pollLast();
                    root2 = root2.right;
                    root1= null;
                }
            }else if(root1 != null){
                System.out.println(root1.data);
                root1= s1.pollFirst();
                root1 = root1.right;
            }else if(root2 != null){
                System.out.println(root2.data);
                root2 = s2.pollLast();
                root2 = root2.right;
            }
            if(root1 == null && root2 == null && s1.isEmpty() && s2.isEmpty()){
                break;
            }
        }
    }

}

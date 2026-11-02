package com.interview.tree;

import com.interview.linkedlist.Node;

import java.util.Deque;
import java.util.LinkedList;

public class CousinNodes {

 public boolean    areCousins(Node root, int a, int b){


     Deque<Node> queue = new LinkedList<>();
     queue.offerFirst(root);
     boolean firstFound = false;
     int levelsize = 1;
     int tempLevelSize = 1;
     while(!queue.isEmpty()){
         levelsize=0;
         while(tempLevelSize > 0){
             root = queue.pollLast();
             if(checkSameParent(root, a, b)){
                 return false;
             }
             if(root.data == a || root.data == b){
                 if(firstFound){
                     return true;
                 }
                 firstFound=true;
             }
             if(root.left != null){
                 queue.offerFirst(root.left);
                 levelsize++;
             }
             if(root.right != null){
                 queue.offerFirst(root.right);
                 levelsize++;
             }
             tempLevelSize --;

         }
         if(firstFound){
             return false;
         }
         tempLevelSize = levelsize;

     }
     return false;

 }

 private boolean checkSameParent(Node root, int a, int b){
     if(root == null) return false;
     if(root.left != null && root.right != null){
         if( (root.left.data == a || root.right.data == b) && (root.right.data ==a || root.left.data == b) ){
             return true;
         }
     }
     return false;
 }
}

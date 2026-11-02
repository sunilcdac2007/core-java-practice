package com.interview.tree;

import com.interview.linkedlist.Node;

import java.util.Deque;
import java.util.LinkedList;

public class SpiralTraversal {


    static void main() {
        int arr[] = {4,2,6,1,5,7,9};
        Node root = Tree.creatTree(arr);
        SpiralTraversal traversal = new SpiralTraversal();
        traversal.spiral(root);
    }

    public void spiral(Node root){
        if(root == null) return;

        Deque<Node> queue = new LinkedList<>();
        queue.offerFirst(root);
        int count =1;
        boolean flip = true;
        while(!queue.isEmpty()){

            int currentCount =0;
            while(count > 0){

                root = queue.pollFirst();
                System.out.println(root.data);
                if(flip){
                    if(root.left != null){
                        queue.offerFirst(root.left);
                        currentCount++;
                    }
                    if(root.right != null){
                        queue.offerFirst(root.right);
                        currentCount++;
                    }

                } else {
                    if(root.left != null){
                        queue.offerLast(root.left);
                        currentCount++;
                    }
                    if(root.right != null){
                        queue.offerLast(root.right);
                        currentCount++;
                    }
                }
                count--;
            }
            count = currentCount;
            flip = !flip;
        }

    }

}

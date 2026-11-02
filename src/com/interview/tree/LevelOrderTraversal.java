package com.interview.tree;

import com.interview.linkedlist.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

    static void main() {
        int arr[] = {4,2,6,1,5,7,9};
        Node root = Tree.creatTree(arr);
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.travers(root);
    }
    public void travers(Node root){

        if(root == null) return;

        Stack<Integer> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            root = queue.poll();
          //  System.out.println(root.data);

            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }


            stack.push(root.data);
        }

        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}

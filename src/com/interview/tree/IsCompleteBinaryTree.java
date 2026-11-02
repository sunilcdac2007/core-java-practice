package com.interview.tree;

import com.interview.linkedlist.Node;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBinaryTree {

    public boolean isComplete( Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundFirstNonNull = false;
        while(!queue.isEmpty()){
            root = queue.poll();
            if(foundFirstNonNull){
                if(root.left != null || root.right != null){
                    return false;
                }
                continue;
            }
            if(root.left != null && root.right != null){
                queue.offer(root.left);
                queue.offer(root.right);
            }else if (root.left != null){
                queue.offer(root.left);
                foundFirstNonNull = true;
            } else if (root.right != null){
                return false;
            } else {
                foundFirstNonNull=true;
            }
        }
        return true;

    }

}

package com.interview.tree;

import com.interview.linkedlist.Node;

import javax.print.DocFlavor;

public class ClosestValueBT {
    static void main() {
        int arr[] = {4,2,6,1,5,7,9};
        Node root = Tree.creatTree(arr);
        int target = 8;
        int result = target > 0 ? Integer.MIN_VALUE: Integer.MAX_VALUE;
       int val= closestVal(root, target, result);
        System.out.println(val);

    }

    public static int closestVal (Node root, int target, int result){
        if(root == null) return result;
        if(root.data == target){
            return root.data;
        }
        if( Math.abs(root.data - target) < Math.abs(result-target) ){
            result = root.data;
        }

        if(Math.abs(root.data -target) > 0 ){
            return closestVal(root.right, target, result);
        } else {
            return closestVal(root.left, target, result);
        }
    }
}

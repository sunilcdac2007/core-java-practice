package com.interview.tree;

import com.interview.linkedlist.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructTreeFromLevelOrderInorder {


    static void main() {
        int[] inorder = {2,3,4,5,7,9,11};
        int[] levelOrder =  { 5, 3, 9, 2, 4, 7,11};
        ConstructTreeFromLevelOrderInorder constructTreeFromLevelOrderInorder = new ConstructTreeFromLevelOrderInorder();
        Node root = constructTreeFromLevelOrderInorder.consructTree(inorder, levelOrder, 0, inorder.length - 1);
        System.out.println(root);
    }
    private int search(int arr[], int key, int low, int high){
        if(low > high){
            return -1;
        }
        int middle = (low + high)/2;
        if(arr[middle] == key){
            return middle;
        } else if (arr[middle] > key){
            return search(arr, key, low, middle-1);
        } else {
            return search(arr, key, middle+1, high);
        }
    }

    private int[] extractArray(int[] inOrder, int[] levelOrder, int low, int high){
   int[] result = new int[high-low+1];
   int pointer=0;
   for(int index =1; index < levelOrder.length; index++){
       int ind = search(inOrder, levelOrder[index], low, high);
       if(ind != -1){
           result[pointer++]= inOrder[ind];
       }
   }
   return result;
    }

    private Node consructTree(int[] inOrder, int[] levelOrder, int low, int high){
        if(low > high){
            return null;
        }
        int levelOrderElement = levelOrder[0];
        Node root = new Node(levelOrderElement);
        int index = search(inOrder, levelOrderElement, low, high);
        int[] left = extractArray(inOrder, levelOrder, low, index-1);
        int[] right = extractArray(inOrder, levelOrder, index+1, high);
        root.left = consructTree(inOrder, left, low, index-1);
        root.right = consructTree(inOrder, right, index+1, high);
        return root;
    }

}

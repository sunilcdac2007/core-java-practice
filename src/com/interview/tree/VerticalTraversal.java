package com.interview.tree;

import com.interview.linkedlist.Node;

import java.util.*;

public class VerticalTraversal {

    static void main() {
        int arr[] = {4,2,6,1,5,7,9};
        Node root = Tree.creatTree(arr);
        VerticalTraversal verticalTraversal = new VerticalTraversal();
        List<List<Integer>> lst = verticalTraversal.verticalOrder(root);
        System.out.println(lst);
    }
    public List<List<Integer>> verticalOrder(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        Deque<Node> queue = new LinkedList<>();
        Deque<Integer> verticalIndex = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.offerFirst(root);
        verticalIndex.offerFirst(0);
        int vertical;
        int min=0;
        int max =0;

        while(!queue.isEmpty()){


            root = queue.pollFirst();
            vertical= verticalIndex.pollFirst();
            min = Math.min(min, vertical);
            max = Math.max(max, vertical);
            List<Integer>  lst = map.get(vertical);
            if(lst == null){
                lst = new ArrayList<>();
                map.put(vertical, lst);
            }
            lst.add(root.data);

            if(root.left != null){
                queue.offerLast(root.left);
                verticalIndex.offerLast(vertical-1);
            }
            if(root.right != null){
                queue.offerLast(root.right);
                verticalIndex.offerLast(vertical+1);
            }

        }

        List<List<Integer>> result = new ArrayList<>();

        for(int index = min; index<= max; index++ ){
          result.add(map.get(index));
        }
        return result;
    }
}

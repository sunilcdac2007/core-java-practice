package com.interview.tree;

import com.interview.linkedlist.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConstructAllBinaryTreeFromInorderTrav {

    static void main() {
        int n=5;
        List<Node> nodes = construct(1,n);
        System.out.println(nodes.size());
    }
 static    List<Node> construct(int start, int end){

        if(start> end){
            return Collections.singletonList(null);
        }

        List<Node> result = new ArrayList<>();
        for(int index = start; index <= end; index++){
            List<Node> leftNode = construct(start, index-1);
            List<Node> rightNode = construct(index+1, end);
            for(Node left: leftNode){
                for(Node right: rightNode){

                    Node node = new Node(index);
                    node.left=left;
                    node.right=right;
                    result.add(node);
                }
            }

        }
        return result;
    }
}

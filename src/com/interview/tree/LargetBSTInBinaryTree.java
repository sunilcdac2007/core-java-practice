package com.interview.tree;

import com.interview.linkedlist.Node;

public class LargetBSTInBinaryTree {

    public int largetBST(Node node){

        MinMax m = larget(node);
        return m.size;
    }

    private MinMax larget(Node root) {
        if(root == null) return new MinMax();
        MinMax leftMinMax = larget(root.left);
        MinMax rightMinMax = larget(root.right);
        MinMax m = new MinMax();
        if(!leftMinMax.isBST || !rightMinMax.isBST || leftMinMax.max > root.data || rightMinMax.min <= root.data){
            m.isBST=false;
            m.size = Math.max(leftMinMax.size, rightMinMax.size);
            return m;
        }

        m.isBST = true;
        m.size = leftMinMax.size + rightMinMax.size + 1;

        m.min = root.left != null ? leftMinMax.min: root.data;
        m.max =  root.right != null ? rightMinMax.max: root.data;
        return m;
    }

    class MinMax{
        int min;
        int max;
        boolean isBST;
        int size;

        MinMax(){
            this.isBST=true;
            this.size =0;
            this.min = Integer.MIN_VALUE;
            this.max = Integer.MAX_VALUE;
        }
    }
}

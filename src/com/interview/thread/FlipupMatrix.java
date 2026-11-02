package com.interview.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class FlipupMatrix {

    int[][] matrix;
    int size;
    AtomicInteger pos;

    FlipupMatrix(int n){
        matrix = new int[n][n];
        this.size = n;
        this.pos= new AtomicInteger(-1);
    }

    public void updateMatrix(){
      int position = pos.getAndIncrement();

      updateMatrix(position);

    }

    public void updateMatrix(int pos){

        if(pos >= size*size){
            throw new IllegalArgumentException();
        }
        matrix[pos/size][pos%size]=1;
    }

    public int getVal(int x, int y){
        return matrix[x][y];
    }
}

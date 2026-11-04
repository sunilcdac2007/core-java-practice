package com.interview.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {

    static void main() {
        int[][] grid = {
                {1,0,0,0,1},
                {0,0,0,1,1},
                {1,0,1,0,0}
        };
        minTotalDistance(grid);
    }
    public static int minTotalDistance(int[][] grid){
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        List<Integer> vertical = new ArrayList<>();
        List<Integer> horizontal = new ArrayList<>();
        for(int i=0; i < grid.length; i++){
            for( int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    vertical.add(i);
                    horizontal.add(j);
                }
            }
        }

        Collections.sort(vertical);
        Collections.sort(horizontal);
        int size = vertical.size()/2;
        int x = vertical.get(size);
        int y = horizontal.get(size);
        int distance = 0;
        for(int i =0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    distance = distance + Math.abs(x-i) + Math.abs(y-j);
                }
            }
        }
        return distance;
    }
}

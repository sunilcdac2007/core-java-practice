package com.interview.array;

import java.util.HashSet;
import java.util.Set;

public class DuplicateWithKIndices {

    public boolean duplicate(int[] arr, int k){
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i < arr.length; i++){
            if(visited.contains(arr[i])){
                return true;
            }
            if(i >= k){
                visited.remove(arr[i-k]);
            }
            visited.add(arr[i]);
        }
        return false;

    }
}

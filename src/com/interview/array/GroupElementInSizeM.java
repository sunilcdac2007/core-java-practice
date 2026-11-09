package com.interview.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GroupElementInSizeM {

    static void main() {
        GroupElementInSizeM group = new GroupElementInSizeM();
        int[] arr = {2,1,5,1,3,5,3,3,4};
        group.group(arr, 3);
    }

    public boolean group(int[] arr, int m){
        Map<Integer, Integer> countMap = new HashMap<>();
        for( Integer num: arr){
            int c = 1;
            if( countMap.containsKey(num)){
                c = countMap.get(num);
                c++;
            }

            countMap.put(num,c);
        }

        PriorityQueue<Pair> pqHeap = new PriorityQueue<>((p1,p2) -> p1.count <= p2.count ? 1: -1);
        for(Integer s: countMap.keySet()){
            int c = countMap.get(s);
            if(c > Math.ceil(arr.length *1.0/m)){
                return false;
            }
            pqHeap.offer(new Pair(s,c));
        }
        int current = 0;
        int start = current;

        while(pqHeap.size()>0){
            Pair p = pqHeap.poll();
            int i = 0;
            while(i < p.count){
                arr[start] = p.num;
                start = start + m;
                if(start > arr.length){
                    current++;
                    start = current;
                }
                i++;
            }
        }

        return true;
    }
}

class Pair{
    int num;
    int count;

    public Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }
}
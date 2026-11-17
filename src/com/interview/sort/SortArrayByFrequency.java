package com.interview.sort;

import java.util.*;

public class SortArrayByFrequency {

    static void main() {
        Integer[] arr = { 5,2,8,9,9,9,2,9};
        SortArrayByFrequency frq = new SortArrayByFrequency();
        frq.sortByFrequency(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortByFrequency(Integer[] arr){

        Map<Integer,SortNode> map = new HashMap<>();

        int index = 0;
        for(int num: arr){
            if(map.containsKey(num)){
                SortNode node = map.get(num);
                node.count++;
            } else {
                SortNode node = new SortNode(1, index);
                map.put(num, node);
            }
            index++;
        }
        sort(Arrays.asList(arr), map);

    }

    public void sort(List<Integer> arr, Map<Integer,SortNode> map ){

        arr.sort((Integer num1, Integer num2) -> {
            SortNode node1 = map.get(num1);
            SortNode node2 = map.get(num2);

            if (node1.count > node2.count) {
                return -1; // higher frequency first
            } else if (node1.count < node2.count) {
                return 1;
            } else {
                if (node1.firstIndex < node2.firstIndex) {
                    return -1; // earlier occurrence first
                } else if (node1.firstIndex > node2.firstIndex) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    class SortNode{
        public SortNode(int count, int firstIndex) {
            this.count = count;
            this.firstIndex = firstIndex;
        }

        int count;
        int firstIndex;
    }
}

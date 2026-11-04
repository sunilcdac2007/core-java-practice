package com.interview.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ChunkMerge {

    public List<Integer> merge(List<List<Integer>> chunks){
   List<Integer> result = new ArrayList<>();
        PriorityQueue<Triplet> queue = new PriorityQueue<>((a, b) ->a.val <=b.pos? -1: 1);
        for(int i=0; i < chunks.size(); i++){
            queue.add(new Triplet(i, chunks.get(i).get(0), 1));
        }
        while (!queue.isEmpty()){
            Triplet p = queue.poll();
            result.add(p.val);
            if(p.index < chunks.get(p.pos).size()){
                p.val = chunks.get(p.pos).get(p.index);
                p.index = p.index+1;
                queue.add(p);
            }
        }
        return result;
    }

}

class Triplet{
    int pos;
    int val;
    int index;

    public Triplet(int val, int pos, int index) {
        this.val = val;
        this.pos = pos;
        this.index = index;
    }
}

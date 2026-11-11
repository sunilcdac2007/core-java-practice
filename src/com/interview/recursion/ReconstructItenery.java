package com.interview.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReconstructItenery {

    static void main() {
        String[][] tickes = {
                {"MUC","LHR"},
                {"JFK", "MUC"},
                {"SFO","SJC"},
                {"LHR", "SFO"}
        };

        List<Itneray> tickets = new ArrayList<>();
        for(String[] ticket: tickes){
            tickets.add(new Itneray(ticket[0], ticket[1]));
        }
        Collections.sort(tickets, (t1,t2)->{
            if(t1.start.equalsIgnoreCase(t2.start)){
               return t1.destination.compareTo(t2.destination) ;
            }else {
                return t1.start.compareTo(t2.start);
            }
        });
        System.out.println(tickets);
        List<String> output = new ArrayList<>();
        boolean[] used = new boolean[tickes.length];
        boolean isExist = findItineraryUtil(tickets, used, "JFK", output, 0);
        System.out.println(" is exist "+ isExist);
    }

    private static boolean  findItineraryUtil(List<Itneray> tickets, boolean[] used, String endStation, List<String> output, int count) {

        if(count == used.length){
            output.add(endStation);
            return true;
        }
        for(int i=0; i < tickets.size(); i++){
            if(used[i]) continue;
            Itneray it = tickets.get(i);
            if(it.start.equalsIgnoreCase(endStation)){
                output.add(it.start);
                if(findItineraryUtil(tickets, used, it.destination, output, count+1)){
                    return true;
                }
                used[i] = false;
                output.remove(output.size()-1);
            }
        }
     return false;
    }

    static class Itneray{
        String start;
        String destination;

        public Itneray(String start, String destination) {
            this.start = start;
            this.destination = destination;
        }
    }
}

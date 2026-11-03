package com.interview.dp;

public class TextJustification {

    // words = [ "sunil","have", "to", "proof", "yourself" "for" , "java", "coding"]

    public String justify(String[] words, int width){
        int cost[][] = new int[words.length][words.length];
        for(int i=0; i < words.length; i++){
            cost[i][i] = width - words[i].length();
            for(int j=i+1; j < words.length; j++){
                cost[i][j] = cost[i][j-1] - words[j].length() -1;
            }
        }
        for(int i=0; i < words.length; i++){
            for(int j=i ; j < words.length; j++){
                if(cost[i][j] < 0){
                    cost[i][j] = Integer.MAX_VALUE;
                } else {
                    cost[i][j] = (int)Math.pow(cost[i][j],2);
                }
            }
        }

        int minCost[] = new int[words.length];
        int result[] = new int[words.length];
        for(int i= words.length -1; i>=0; i--){
            minCost[i] = cost[i][words.length-1];
            result[i] = words.length;
            for(int j=words.length -1; j > i; j--){
                if(cost[i][j-1] == Integer.MAX_VALUE){
                    continue;
                }
                if(minCost[i] > minCost[j] + cost[i][j-1]){
                    minCost[i] = minCost[j] + cost[i][j-1] ;
                    result[i] = j;
                }
            }
        }
        int i=0;
        int j;
        StringBuilder builder = new StringBuilder();
        do{
            j= result[i];
            for(int k=i; k < j; k++){
                builder.append(words[k] +" ");
            }
            builder.append("\n");
            i = j;
        }while(j < words.length);
        return builder.toString();
    }

    static void main() {
        String[] words = {"sunil","have", "to", "proof", "yourself", "for" , "java", "coding"};
        int width = 12;
        TextJustification text = new TextJustification();
        String formatedText = text.justify(words, width);
        System.out.println(formatedText);
    }

}

package com.interview.array;

import java.util.ArrayList;
import java.util.List;

public class GreedyTextJustification {

public List<String> fullJustify(String[] words, int maxWidth){

    List<String> result = new ArrayList<>();
    for( int i=0; i < words.length;){
        int total = words[i].length();
        int j = i + 1;
        StringBuilder buff = new StringBuilder();
        buff.append(words[i]);
        while(j < words.length && total + words[j].length() +1 <= maxWidth){
            total = total + words[j].length() + 1;
            j++;
        }
        int remaining = maxWidth-total;

        if(j != words.length){
            int count = j - i -1;
            if( count == 0){
                padSpace(buff, remaining);
            } else {
                int q = remaining/count;
                int r = remaining%count;
                for( int k = i+1; k < j; k++){
                    padSpace(buff, q);
                    if(r > 0){
                        buff.append(" ");
                        r--;
                    }
                    buff.append(" ").append(words[k]);

                }
            }
        }else {
            for(int k = i+1; k < j; k++){
                buff.append(" ").append(words[k]);
            }
            padSpace(buff, remaining);
        }
        result.add(buff.toString());
        i = j;
    }
  return result;
   }

    private void padSpace(StringBuilder buff, int remaining) {
      for( int i=0; i < remaining; i++){
          buff.append(" ");
      }
    }

    static void main() {

        String[] words = {"sunil","have", "to", "proof", "yourself", "for" , "java", "coding"};
        int width = 12;
        GreedyTextJustification greedyTextJustification = new GreedyTextJustification();
        List<String> str = greedyTextJustification.fullJustify(words, width);
        System.out.println(str);
    }
}

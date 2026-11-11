package com.interview.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParenthesis {

    public List<String> removeInvalidParenth(String text){

        Set<String> res = new HashSet<>();
        int rmL =0, rmR = 0;
        for(int i=0; i < text.length(); i++){
            if(text.charAt(i) == '(') rmL++;
            if(text.charAt(i) == ')'){
                if(rmL != 0) rmL--;
                else rmR++;
            }
        }
        removeUtility(res, text, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<>(res);

    }

    private void removeUtility(Set<String> res, String text, int startIndex, int rmL, int rmR, int openIndex, StringBuilder stringBuilder) {
       if(startIndex == text.length() && rmL == 0 && rmR == 0 && openIndex ==0){
           res.add(stringBuilder.toString());
           return;
       }

       if(startIndex == text.length() || rmL <0 || rmR < 0 || openIndex <0 ) return;
       char c = text.charAt(startIndex);
       int len = stringBuilder.length();
       if(c == '('){
           removeUtility(res, text, startIndex+1, rmL -1, rmR,openIndex,stringBuilder);
           removeUtility(res, text, startIndex+1, rmL , rmR,openIndex + 1,stringBuilder.append(c));
       } else if (c == ')'){
           removeUtility(res, text, startIndex+1, rmL , rmR - 1,openIndex,stringBuilder);
           removeUtility(res, text, startIndex+1, rmL , rmR,openIndex - 1,stringBuilder.append(c));
       } else {
           removeUtility(res, text, startIndex+1, rmL , rmR,openIndex,stringBuilder.append(c));
       }
       stringBuilder.setLength(len);
    }
}

package com.interview.array;

import java.math.BigInteger;

public class AdditiveNumber {

    // 2 3 5 8 13
    //

    static void main() {
       boolean additive =  isAddititveNumber("235813");
        System.out.println(additive);
    }
    public static boolean isAddititveNumber(String num){
       if(num.length() < 3){
           return false;
       }
       for(int i=0; i <= num.length()/2; i++){
           if(num.charAt(0) == '0' && i > 0){
               break;
           }
           BigInteger x1 = new BigInteger(num.substring(0,i+1));
           for(int j = i+1; Math.max(i, j-(i+1)) + 1 <= num.length()-j-1; j++){
               if(num.charAt(i+1) == '0' && j > i+1){
                   break;
               }
               BigInteger x2 = new BigInteger(num.substring(i+1, j+1));
               if(isValid(num, j+1, x1,x2)){
                   return true;
               }
           }
       }
       return false;
    }

    private static boolean isValid(String num, int start, BigInteger x1, BigInteger x2) {
      if(start == num.length() -1) return true;
      BigInteger x3 = x1.add(x2);
      return num.startsWith(x3.toString(), start) && isValid(num, start+x3.toByteArray().length, x2, x3);
    }


}

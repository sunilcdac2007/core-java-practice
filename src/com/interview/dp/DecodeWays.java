package com.interview.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    static void main() {
        String str = "1123";
        int numOfWay = numDecodings(str);
        System.out.println(numOfWay);
        int anotherWay = numDecodingDP(str);
        System.out.println(anotherWay);
    }

    public static int numDecodings(String decodedStr){

        if(decodedStr.length() ==0){
            return 0;
        }
        Map<Integer, Integer> dpCount = new HashMap<>();
        return numDecodingUtil(decodedStr, 0,dpCount );
    }

    private static int numDecodingUtil(String decodedStr, int start, Map<Integer, Integer> dpCount) {

      if(decodedStr.length() == start){
          return 1;
      }
      if(dpCount.containsKey(start)){
          return  dpCount.get(start);
      }
      String str = decodedStr.substring(start, start+1);
      if(str.equalsIgnoreCase("0")){
          dpCount.put(start,0);
          return 0;
      }

      int decodeWay1 = numDecodingUtil(decodedStr, start+1, dpCount);
      int decodeWay2 =0;
      if(start < decodedStr.length()-1){
          str= decodedStr.substring(start, start+2);
          if(Integer.valueOf(str) <= 26){
              decodeWay2 = numDecodingUtil(decodedStr, start+2, dpCount);
          }
      }
      dpCount.put(start, decodeWay1+decodeWay2);
      return decodeWay1+ decodeWay2;
    }

    static final int upperLimit = 26;
    static final int maxHeadSize = 2;

    static int numDecodingDP(String encodedText){
        int[] dp = new int[encodedText.length()+1];
        return numDecodingDP(encodedText, dp);
    }

    private static int numDecodingDP(String encodedText, int[] dp) {

        if(encodedText.length() ==0){
            return 1;
        }
        if(dp[encodedText.length()] != 0){
            return dp[encodedText.length()];
        }

        int sum =0;
        for(int headSize =1; headSize <= maxHeadSize && headSize <= encodedText.length(); headSize++){
            String head = encodedText.substring(0, headSize);
            String tail = encodedText.substring(headSize);
            if(Integer.parseInt(head) >  upperLimit){
                break;
            }
            sum = sum + numDecodingDP(tail, dp);
        }
        dp[encodedText.length()] = sum;
        return sum;
    }

}

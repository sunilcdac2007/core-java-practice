package com.interview.string;

public class ValidPalindrome {


    private boolean isAlphanum(char ch){
        if( (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
            return true;
        }
        return false;
    }


    public boolean isPalindrom(String str){

        int start = 0;
        int end = str.length() -1;

        while ( start < end){
            if(!isAlphanum(str.charAt(start))){
                start++;
            } else if (!isAlphanum(str.charAt(end))){
                end--;
            }else {
                if(Character.toLowerCase(str.charAt(start++)) != Character.toLowerCase(str.charAt(end--))){
                    return false;
                }
            }
        }
        return true;
    }

    static void main() {
        String str = "A MAN A****** PLAN A CANAL: **** ## PANAMA";
        ValidPalindrome pal = new ValidPalindrome();
        System.out.println(pal.isPalindrom(str));
    }

}

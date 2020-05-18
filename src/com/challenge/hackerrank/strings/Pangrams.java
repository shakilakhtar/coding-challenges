package com.challenge.hackerrank.strings;

/**
 * @author Shakil Akhtar
 */
public class Pangrams {

    // Complete the pangrams function below.
    static String pangrams(String s) {
        String l=s.toLowerCase();
        String r="pangram";
        //take array of letters
        for(int i='a';i<'z';i++){
            if(l.indexOf(i) ==-1){
                r="not pangram";
            }
        }

        return r;
    }

    public static void main(String[] args) {

        String s= "We promptly judged antique ivory buckles for the prize";
        System.out.println(pangrams(s));
    }
}

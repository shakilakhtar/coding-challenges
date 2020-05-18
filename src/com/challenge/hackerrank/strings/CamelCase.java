package com.challenge.hackerrank.strings;

import java.util.stream.IntStream;
/**
 * @author Shakil Akhtar
 */
public class CamelCase {

    // Complete the camelcase function below.
    static int camelcase(String s) {

        char[] array =s.toCharArray();
        int wcount=1;
        for(char c:array){
            if(c >= 'A' && c <= 'Z'){
                wcount+=1;
            }
        }
      return wcount;
    }


    public static void main(String[] args) {

        int w=camelcase("saveChangesInTheEditor");
        System.out.println(w);
    }
}

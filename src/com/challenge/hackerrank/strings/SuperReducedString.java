package com.challenge.hackerrank.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Shakil Akhtar
 */
public class SuperReducedString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {

        if(!isAdjacentAvailable(s)){
           return s.equals("")?"Empty String":s;
        }
        List<Character> ca = s.chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());
        //char[] ca = s.toCharArray();
        //Arrays.sort(ca);
        for(int i=0;i<ca.size();i++){
            char temp=ca.get(i);
            if(i+1<=ca.size()-1) {
                if (temp == ca.get(i + 1)) {
                    ca.remove(i+1);
                    ca.remove(i);
                }
            }
        }
        String reducedString = ca.stream()  			// Stream<Character>
                .map(String::valueOf)   // Stream<String>
                .collect(Collectors.joining());

        return superReducedString(reducedString);
    }
    //does string contains adjacent character same

    static boolean isAdjacentAvailable(String s){
        boolean flag=false;
        char[] ca = s.toCharArray();
        for(int i=0;i<ca.length;i++){
            char temp=ca[i];
            if(i+1<=s.length()-1) {
                if (temp == ca[i + 1]) {
                    flag= true;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        String reduced=superReducedString("baab");
        System.out.println(reduced);
    }
}

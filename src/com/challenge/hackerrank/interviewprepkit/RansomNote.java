package com.challenge.hackerrank.interviewprepkit;

import java.util.HashMap;
import java.util.Map;

/**
 * Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use only whole words available in the magazine. He cannot use substrings or concatenation to create the words he needs.
 * <p>
 * Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
 * <p>
 * For example, the note is "Attack at dawn". The magazine contains only "attack at dawn". The magazine has all the right words, but there's a case mismatch. The answer is .
 *
 * Sample Input 1
 *
 * 6 5
 * two times three is not four
 * two times two is four
 * Sample Output 1
 *
 * No
 *
 *
 * @author shakil akhtar
 */
public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> keyMap = new HashMap<>();
        for (String w : magazine) {
            if (keyMap.containsKey(w)) {
                int occurance = keyMap.get(w);
                keyMap.put(w, occurance + 1);
            } else {
                keyMap.put(w, 1);
            }
        }

        boolean printed = false;
        for (int i = 0; i < note.length; i++) {
            if (!keyMap.containsKey(note[i])) {
                System.out.println("No");
                printed = true;
                break;
            } else if (keyMap.containsKey(note[i])) {
                int count = keyMap.get(note[i]);
                if (count == 1) {
                    keyMap.remove(note[i]);
                } else {
                    keyMap.put(note[i], count - 1);
                }
            }
        }
        if (!printed) {
            System.out.println("Yes");
        }

    }

    public static void main(String[] args) {
        String[] m = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};

        checkMagazine(m, note);
    }
}

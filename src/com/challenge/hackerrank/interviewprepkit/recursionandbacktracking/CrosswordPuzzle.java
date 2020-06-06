package com.challenge.hackerrank.interviewprepkit.recursionandbacktracking;

import java.util.*;

/**
 * A  Crossword grid is provided to you, along with a set of words (or names of places) which need to be filled into the grid. Cells are marked either + or -. Cells marked with a - are to be filled with the word list.
 * <p>
 * The following shows an example crossword from the input  grid and the list of words to fit, :
 * <p>
 * Input 	   		Output
 * <p>
 * ++++++++++ 		++++++++++
 * +------+++ 		+POLAND+++
 * +++-++++++ 		+++H++++++
 * +++-++++++ 		+++A++++++
 * +++-----++ 		+++SPAIN++
 * +++-++-+++ 		+++A++N+++
 * ++++++-+++ 		++++++D+++
 * ++++++-+++ 		++++++I+++
 * ++++++-+++ 		++++++A+++
 * ++++++++++ 		++++++++++
 * POLAND;LHASA;SPAIN;INDIA
 * Function Description
 * <p>
 * Complete the crosswordPuzzle function in the editor below. It should return an array of strings, each representing a row of the finished puzzle.
 * <p>
 * crosswordPuzzle has the following parameter(s):
 * <p>
 * crossword: an array of  strings of length  representing the empty grid
 * words: a string consisting of semicolon delimited strings to fit into
 * Input Format
 * <p>
 * Each of the first  lines represents , each of which has  characters, .
 * <p>
 * The last line contains a string consisting of semicolon delimited  to fit.
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Position the words appropriately in the  grid, then return your array of strings for printing.
 * <p>
 * Sample Input 0
 * <p>
 * +-++++++++
 * +-++++++++
 * +-++++++++
 * +-----++++
 * +-+++-++++
 * +-+++-++++
 * +++++-++++
 * ++------++
 * +++++-++++
 * +++++-++++
 * LONDON;DELHI;ICELAND;ANKARA
 * Sample Output 0
 * <p>
 * +L++++++++
 * +O++++++++
 * +N++++++++
 * +DELHI++++
 * +O+++C++++
 * +N+++E++++
 * +++++L++++
 * ++ANKARA++
 * +++++N++++
 * +++++D++++
 * Sample Input 1
 * <p>
 * +-++++++++
 * +-++++++++
 * +-------++
 * +-++++++++
 * +-++++++++
 * +------+++
 * +-+++-++++
 * +++++-++++
 * +++++-++++
 * ++++++++++
 * AGRA;NORWAY;ENGLAND;GWALIOR
 * Sample Output 1
 * <p>
 * +E++++++++
 * +N++++++++
 * +GWALIOR++
 * +L++++++++
 * +A++++++++
 * +NORWAY+++
 * +D+++G++++
 * +++++R++++
 * +++++A++++
 * ++++++++++
 * Sample Input 2
 * <p>
 * XXXXXX-XXX
 * XX------XX
 * XXXXXX-XXX
 * XXXXXX-XXX
 * XXX------X
 * XXXXXX-X-X
 * XXXXXX-X-X
 * XXXXXXXX-X
 * XXXXXXXX-X
 * XXXXXXXX-X
 * ICELAND;MEXICO;PANAMA;ALMATY
 * Sample Output 2
 * <p>
 * XXXXXXIXXX
 * XXMEXICOXX
 * XXXXXXEXXX
 * XXXXXXLXXX
 * XXXPANAMAX
 * XXXXXXNXLX
 * XXXXXXDXMX
 * XXXXXXXXAX
 * XXXXXXXXTX
 * XXXXXXXXYX
 */
public class CrosswordPuzzle {

    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String input) {
        char ch[][] = new char[10][10];
        char limitter = '+';
        for (int i = 0; i < 10; i++) {
            if (crossword[i].indexOf('X') > -1)
                limitter = 'X';
            ch[i] = crossword[i].toCharArray();
        }

        String[] words = input.split(";");
        Map<Integer, List<String>> map = new HashMap<>();
        for (String word : words) {
            int k = word.length();
            if (map.containsKey(k)) {
                List<String> list = map.get(k);
                list.add(word);
                map.put(k, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(k, list);
            }
        }
        fill(ch, map, limitter);
        for (int i = 0; i < 10; i++)
            crossword[i] = String.valueOf(ch[i]);
        return crossword;
    }

    static boolean placeWordHorizontally(char[][] ch, String word, char limitter) {
        int len = word.length();
        for (int i = 0; i < 10; i++) {
            int j = 0;
            inner:
            while (j <= 10 - len) {
                int k = j;
                for (k = j; k < j + len; k++)
                    if (ch[i][k] == limitter) break;

                if (k == j + len) {
                    if ((k <= 9 && ch[i][k] != limitter) || (j > 0 && ch[i][j - 1] != limitter)) {
                        j++;
                        continue;
                    }
                    //means space is free
                    for (k = j; k < j + len; k++) {
                        if (ch[i][k] != '-' && word.charAt(k - j) != ch[i][k]) {
                            j++;
                            continue inner;
                        }
                    }
                    //correct place
                    for (k = j; k < j + len; k++)
                        ch[i][k] = word.charAt(k - j);
                    return true;
                }
                j++;
            }
        }
        return false;
    }


    static boolean placeWordVertically(char[][] ch, String word, char limitter) {
        int len = word.length();
        for (int i = 0; i < 10; i++) {
            int j = 0;
            inner:
            while (j <= 10 - len) {
                int k = j;
                for (k = j; k < j + len; k++)
                    if (ch[k][i] == limitter) break;

                if (k == j + len) {
                    if ((k <= 9 && ch[k][i] != limitter) || (j > 0 && ch[j - 1][i] != limitter)) {
                        j++;
                        continue;
                    }
                    //means space is free
                    for (k = j; k < j + len; k++) {
                        if (ch[k][i] != '-' && word.charAt(k - j) != ch[k][i]) {
                            j++;
                            continue inner;
                        }
                    }
                    //correct place
                    for (k = j; k < j + len; k++)
                        ch[k][i] = word.charAt(k - j);
                    return true;
                }
                j++;
            }
        }
        return false;
    }


    static void fill(char[][] ch, Map<Integer, List<String>> map, char limitter) {
        //try filling map words one by one..
        boolean isComplete = true;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet())
            if (!entry.getValue().isEmpty()) {
                isComplete = false;
                break;
            }
        if (isComplete) return;
        char[][] backup = new char[10][10];
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            int len = entry.getKey();
            List<String> wordList = entry.getValue();
            for (String word : wordList) {
                if (placeWordHorizontally(ch, word, limitter) || placeWordVertically(ch, word, limitter)) {
                    //since this word is placed remove this word from map...
                    List<String> newWordList = new ArrayList<>();
                    for (String w : entry.getValue())
                        newWordList.add(w);

                    newWordList.remove(word);
                    map.put(entry.getKey(), newWordList);
                    for (int a = 0; a < 10; a++)
                        for (int b = 0; b < 10; b++)
                            backup[a][b] = ch[a][b];
                    fill(ch, map, limitter);
                    //if we cant place word here revert action
                    newWordList.add(word);
                    map.put(entry.getKey(), newWordList);
                    for (int a = 0; a < 10; a++)
                        for (int b = 0; b < 10; b++)
                            ch[a][b] = backup[a][b];
                }
            }
        }

    }


    public static void main(String[] args) {

    }
}

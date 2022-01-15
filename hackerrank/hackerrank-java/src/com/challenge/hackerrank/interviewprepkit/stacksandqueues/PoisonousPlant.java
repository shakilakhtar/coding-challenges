package com.challenge.hackerrank.interviewprepkit.stacksandqueues;

import java.util.*;

/**
 * There are a number of plants in a garden. Each of these plants has been treated with some amount of pesticide. After each day, if any plant has more pesticide than the plant on its left, being weaker than the left one, it dies.
 * <p>
 * You are given the initial values of the pesticide in each of the plants. Print the number of days after which no plant dies, i.e. the time after which there are no plants with more pesticide content than the plant to their left.
 * <p>
 * For example, pesticide levels . Using a -indexed array, day  plants  and  die leaving . On day , plant  of the current array dies leaving . As there is no plant with a higher concentration of pesticide than the one to its left, plants stop dying after day .
 * <p>
 * Function Description
 * Complete the function poisonousPlants in the editor below. It must return an integer representing the number of days until plants no longer die from pesticide.
 * <p>
 * poisonousPlants has the following parameter(s):
 * <p>
 * p: an array of integers representing pesticide levels in each plant
 * Input Format
 * <p>
 * The first line contains an integer , the size of the array .
 * The next line contains  space-separated integers .
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Output an integer equal to the number of days after which no plants die.
 * <p>
 * Sample Input
 * <p>
 * 7
 * 6 5 8 4 7 10 9
 * Sample Output
 * <p>
 * 2
 * Explanation
 * <p>
 * Initially all plants are alive.
 * <p>
 * Plants = {(6,1), (5,2), (8,3), (4,4), (7,5), (10,6), (9,7)}
 * <p>
 * Plants[k] = (i,j) => jth plant has pesticide amount = i.
 * <p>
 * After the 1st day, 4 plants remain as plants 3, 5, and 6 die.
 * <p>
 * Plants = {(6,1), (5,2), (4,4), (9,7)}
 * <p>
 * After the 2nd day, 3 plants survive as plant 7 dies.
 * <p>
 * Plants = {(6,1), (5,2), (4,4)}
 * <p>
 * After the 2nd day the plants stop dying.
 */
public class PoisonousPlant {

    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {

        List<List<Integer>> listOfStack = new ArrayList<List<Integer>>();

        int last = -1;
        List<Integer> curStack = null;

        for (int pl : p) {

            if (last == -1) {
                curStack = new ArrayList<Integer>();
                curStack.add(pl);
                listOfStack.add(curStack);
            } else {

                if (last >= pl) {
                    curStack.add(pl);
                } else {
                    curStack = new Stack<Integer>();
                    curStack.add(pl);
                    listOfStack.add(curStack);
                }
            }

            last = pl;
        }

        int day = 0;
        boolean change = false;
        do {

            day++;
            change = false;
            System.out.println(listOfStack.size());
            for (int i = listOfStack.size() - 1; i > 0; i--) {

                List<Integer> current = listOfStack.get(i);
                current.remove(0);

                List<Integer> beforeCurrent = listOfStack.get(i - 1);

                if (current.isEmpty()) {
                    listOfStack.remove(i);
                } else if (current.get(0) <= beforeCurrent.get(beforeCurrent.size() - 1)) {
                    beforeCurrent.addAll(current);
                    listOfStack.remove(i);
                }

                change = true;
            }

        } while (change);

        return day - 1;
    }

    public static void main(String[] args) {

    }
}

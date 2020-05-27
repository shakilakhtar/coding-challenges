package com.challenge.hackerrank.interviewprepkit.dictionaryandhashmap;

import java.util.*;
import java.util.function.*;

/**
 * You are given  queries. Each query is of the form two integers described below:
 * -  : Insert x in your data structure.
 * -  : Delete one occurence of y from your data structure, if present.
 * -  : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.
 * <p>
 * The queries are given in the form of a 2-D array  of size  where  contains the operation, and  contains the data element. For example, you are given array . The results of each operation are:
 * <p>
 * Operation   Array   Output
 * (1,1)       [1]
 * (2,2)       [1]
 * (3,2)                   0
 * (1,1)       [1,1]
 * (1,1)       [1,1,1]
 * (2,1)       [1,1]
 * (3,2)                   1
 * Return an array with the output: .
 * <p>
 * Function Description
 * <p>
 * Complete the freqQuery function in the editor below. It must return an array of integers where each element is a  if there is at least one element value with the queried number of occurrences in the current array, or 0 if there is not.
 * <p>
 * freqQuery has the following parameter(s):
 * <p>
 * queries: a 2-d array of integers
 * Input Format
 * <p>
 * The first line contains of an integer , the number of queries.
 * Each of the next  lines contains two integers denoting the 2-d array .
 * <p>
 * Constraints
 * <p>
 * All
 * Output Format
 * <p>
 * Return an integer array consisting of all the outputs of queries of type .
 * <p>
 * Sample Input 0
 * <p>
 * 8
 * 1 5
 * 1 6
 * 3 2
 * 1 10
 * 1 10
 * 1 6
 * 2 5
 * 3 2
 * Sample Output 0
 * <p>
 * 0
 * 1
 * Explanation 0
 * <p>
 * For the first query of type , there is no integer whose frequency is  (). So answer is .
 * For the second query of type , there are two integers in  whose frequency is  (integers =  and ). So, the answer is .
 * <p>
 * Sample Input 1
 * <p>
 * 4
 * 3 4
 * 2 1003
 * 1 16
 * 3 1
 * Sample Output 1
 * <p>
 * 0
 * 1
 * Explanation 1
 * <p>
 * For the first query of type , there is no integer of frequency . The answer is . For the second query of type , there is one integer,  of frequency  so the answer is .
 * <p>
 * Sample Input 2
 * <p>
 * 10
 * 1 3
 * 2 3
 * 3 2
 * 1 4
 * 1 5
 * 1 5
 * 1 4
 * 3 2
 * 2 4
 * 3 2
 * Sample Output 2
 * <p>
 * 0
 * 1
 * 1
 * Explanation 2
 * <p>
 * When the first output query is run, the array is empty. We insert two 's and two 's before the second output query,  so there are two instances of elements occurring twice. We delete a  and run the same query. Now only the instances of  satisfy the query.
 *
 * @author shakil akhtar
 */
public class FrequencyQueries {


    static List<Integer> freqQuery(List<List<Integer>> queries) {

        Map<Integer, Integer> freqEleMap = new HashMap<>();
        Map<Integer, Integer> freqCountMap = new HashMap<>();

        List<Integer> output = new ArrayList<>();
        queries.forEach(item -> {
            // get operation 1,2,3
            Integer operation = item.get(0);
            Integer element = item.get(1);
            int f = freqEleMap.getOrDefault(element, 0);
            int currFreqElemCount = 0;
            //apply query rules on the values
            switch (operation) {
                case 1:
                    //add one occurrence to the store
                    currFreqElemCount = freqCountMap.getOrDefault(f, 0);
                    if (currFreqElemCount > 0) {
                        freqCountMap.put(f, currFreqElemCount - 1);
                    }
                    f++;
                    freqEleMap.put(element, f);
                    currFreqElemCount = freqCountMap.getOrDefault(f, 0);
                    freqCountMap.put(f, currFreqElemCount + 1);
                    break;
                case 2:
                    // remove one occurrence of element :element
                    if (f > 0) {
                        currFreqElemCount = freqCountMap.getOrDefault(f, 0);
                        if (currFreqElemCount > 0) {
                            freqCountMap.put(f, currFreqElemCount - 1);
                        }
                        f--;
                        freqEleMap.put(element, f);
                        currFreqElemCount = freqCountMap.getOrDefault(f, 0);
                        freqCountMap.put(f, currFreqElemCount + 1);
                    }
                    break;
                case 3:
                    //check if any element is present with frequency==val print 1 else 0
                    currFreqElemCount = freqCountMap.getOrDefault(element, 0);
                    if (currFreqElemCount == 0) {
                        output.add(0);
                    } else {
                        output.add(1);
                    }
                    // output.add(currFreqElemCount == 0 ? 0 : 1);
                    break;

                default: {
                    //Operation not found
                }
            }
        });
        return output;
    }


    static List<Integer> freqQuery2(List<List<Integer>> queries) {
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> elementFreeqMap = new HashMap<>();
        Map<Integer, Integer> freqCountMap = new HashMap<>();
        // int f = 0;
        int currFreqElemCount = 0;
        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int element = query.get(1);
            int f = elementFreeqMap.getOrDefault(element, 0);
            if (operation == 1) {
                // f = elementFreeqMap.getOrDefault(element, 0);
                currFreqElemCount = freqCountMap.getOrDefault(f, 0);
                if (currFreqElemCount > 0) {
                    freqCountMap.put(f, currFreqElemCount - 1);
                }
                f++;
                elementFreeqMap.put(element, f);
                currFreqElemCount = freqCountMap.getOrDefault(f, 0);
                freqCountMap.put(f, currFreqElemCount + 1);
            } else if (operation == 2) {
                //f = elementFreeqMap.getOrDefault(element, 0);
                if (f > 0) {
                    currFreqElemCount = freqCountMap.getOrDefault(f, 0);
                    if (currFreqElemCount > 0) {
                        freqCountMap.put(f, currFreqElemCount - 1);
                    }
                    f--;
                    elementFreeqMap.put(element, f);
                    currFreqElemCount = freqCountMap.getOrDefault(f, 0);
                    freqCountMap.put(f, currFreqElemCount + 1);
                }
            } else if (operation == 3) {
                currFreqElemCount = freqCountMap.getOrDefault(element, 0);
                if (currFreqElemCount == 0) {
                    res.add(0);
                } else {
                    res.add(1);
                }
            } else {
                //error
            }
        }
        return res;
    }

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1, 5);
        List<Integer> l2 = Arrays.asList(1, 6);
        List<Integer> l3 = Arrays.asList(3, 2);
        List<Integer> l4 = Arrays.asList(1, 10);
        List<Integer> l5 = Arrays.asList(1, 10);
        List<Integer> l6 = Arrays.asList(1, 6);
        List<Integer> l7 = Arrays.asList(2, 5);
        List<Integer> l8 = Arrays.asList(3, 2);
        List<List<Integer>> input = new ArrayList<>();
        input.add(l1);
        input.add(l2);
        input.add(l3);
        input.add(l4);
        input.add(l5);
        input.add(l6);
        input.add(l7);
        input.add(l8);

        List<Integer> res = freqQuery(input);
        res.forEach(e -> System.out.print(" " + e));

    }
}

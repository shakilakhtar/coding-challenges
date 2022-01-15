package com.challenge.hackerrank.interviewprepkit.dp;

import java.util.*;

/**
 * Let's talk about binary numbers. We have an -digit binary number, , and we denote the digit at index  (zero-indexed from right to left) to be . We can find the decimal value of  using the following formula:
 * <p>
 * For example, if binary number , we compute its decimal value like so:
 * <p>
 * Meanwhile, in our well-known decimal number system where each digit ranges from  to , the value of some decimal number, , can be expanded in the same way:
 * <p>
 * Now that we've discussed both systems, let's combine decimal and binary numbers in a new system we call decibinary! In this number system, each digit ranges from  to  (like the decimal number system), but the place value of each digit corresponds to the one in the binary number system. For example, the decibinary number  represents the decimal number  because:
 * <p>
 * Pretty cool system, right? Unfortunately, there's a problem: two different decibinary numbers can evaluate to the same decimal value! For example, the decibinary number  also evaluates to the decimal value :
 * <p>
 * This is a major problem because our new number system has no real applications beyond this challenge!
 * <p>
 * Consider an infinite list of non-negative decibinary numbers that is sorted according to the following rules:
 * <p>
 * The decibinary numbers are sorted in increasing order of the decimal value that they evaluate to.
 * Any two decibinary numbers that evaluate to the same decimal value are ordered by increasing decimal value, meaning the equivalent decibinary values are strictly interpreted and compared as decimal values and the smaller decimal value is ordered first. For example,  and  both evaluate to . We would order  before  because .
 * Here is a list of first few decibinary numbers properly ordered:
 * <p>
 * image
 * <p>
 * You will be given  queries in the form of an integer, . For each , find and print the the  decibinary number in the list on a new line.
 * <p>
 * Function Description
 * <p>
 * Complete the decibinaryNumbers function in the editor below. For each query, it should return the decibinary number at that one-based index.
 * <p>
 * decibinaryNumbers has the following parameter(s):
 * <p>
 * x: the index of the decibinary number to return
 * Input Format
 * <p>
 * The first line contains an integer, , the number of queries.
 * Each of the next  lines contains an integer, , describing a query.
 * <p>
 * Constraints
 * <p>
 * Subtasks
 * <p>
 * for  of the maximum score
 * for  of the maximum score
 * for  of the maximum score
 * Output Format
 * <p>
 * For each query, print a single integer denoting the the  decibinary number in the list. Note that this must be the actual decibinary number and not its decimal value. Use 1-based indexing.
 * <p>
 * Sample Input 0
 * <p>
 * 5
 * 1
 * 2
 * 3
 * 4
 * 10
 * Sample Output 0
 * <p>
 * 0
 * 1
 * 2
 * 10
 * 100
 * Explanation 0
 * <p>
 * For each , we print the  decibinary number on a new line. See the figure in the problem statement.
 * <p>
 * Sample Input 1
 * <p>
 * 7
 * 8
 * 23
 * 19
 * 16
 * 26
 * 7
 * 6
 * Sample Output 1
 * <p>
 * 12
 * 23
 * 102
 * 14
 * 111
 * 4
 * 11
 * Sample Input 2
 * <p>
 * 10
 * 19
 * 25
 * 6
 * 8
 * 20
 * 10
 * 27
 * 24
 * 30
 * 11
 * Sample Output 2
 * <p>
 * 102
 * 103
 * 11
 * 12
 * 110
 * 100
 * 8
 * 31
 * 32
 * 5
 *
 * @author shakil akhtar
 */
public class DecibinaryNumbers {

    static long decibinaryNumbers(long x) {
        int p = 0;
        long sum = 0;
        while (x != 0) {
            sum += (x % 10) * new Double(Math.pow(2, p)).longValue();
            x /= x;
            p++;
        }
        System.out.println(sum);
        return sum;
    }

//    static long dbtodeci(long db) {
//        int p = 0;
//        long sum = 0;
//        while (db != 0) {
//            sum += (db % 10) * new Double(Math.pow(2, p)).longValue();
//            db /= 10;
//            p++;
//        }
//        return sum;
//    }


    public static void main(String[] args) {
        long x;
        int index;
        List<Long> numsdec = new LinkedList<Long>();
        List<Long> numsdb = new ArrayList<Long>();
        // here you decide how many values to be precomputed
        for (long i = 0; i < 1000; i++) {
            x = decibinaryNumbers(i);
            if (numsdec.contains(x)) {
                index = numsdec.lastIndexOf(x);
                numsdec.add(index + 1, x);
                numsdb.add(index + 1, i);
            } else {
                numsdec.add(x);
                numsdb.add(x);
            }
        }

//        List<Integer> indexes = new ArrayList<Integer>();
//        System.out.println("nb of queries: ");
//        int q = Convert.ToInt32(Console.ReadLine());
//        for (int i = 0; i < q; i++) {
//            int xth = Convert.ToInt32(Console.ReadLine());
//            indexes.add(xth - 1);
//        }
//        for (int i : indexes)
//            System.out.println(numsdb[i]);
    }
}


//    static long dbtodeci(long db)
//    {
//        int p = 0; long sum = 0;
//        while (db != 0)
//        {
//            sum += (db % 10) * Convert.ToInt64(Math.Pow(2, p));
//            db /= 10; p++;
//        }
//        return sum;
//    }
//
//
//    static void Main(string[] args)
//    {
//        long x; int index;
//        List<long> numsdec = new List<long>();
//        List<long> numsdb = new List<long>();
//        // here you decide how many values to be precomputed
//        for (long i = 0; i < 1000; i++)
//        {
//            x = dbtodeci(i);
//            if (numsdec.Exists(k => k == x))
//            {
//                index = numsdec.FindLastIndex(k => k == x);
//                numsdec.Insert(index + 1, x);
//                numsdb.Insert(index + 1, i);
//            }
//                else
//            {
//                numsdec.Add(x);
//                numsdb.Add(x);
//            }
//        }
//
//        List<int> indexes = new List<int>();
//        Console.Write("nb of queries: ");
//        int q = Convert.ToInt32(Console.ReadLine());
//        for (int i = 0; i < q; i++)
//        {
//            int xth = Convert.ToInt32(Console.ReadLine());
//            indexes.Add(xth - 1);
//        }
//        foreach (int i in indexes)
//        Console.WriteLine(numsdb[i]);
//    }
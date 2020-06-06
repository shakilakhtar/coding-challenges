package com.challenge.hackerrank.interviewprepkit.search;

import java.math.*;

/**
 * Karl loves playing games on social networking sites. His current favorite is CandyMaker, where the goal is to make candies.
 * <p>
 * Karl just started a level in which he must accumulate  candies starting with  machines and  workers. In a single pass, he can make  candies. After each pass, he can decide whether to spend some of his candies to buy more machines or hire more workers. Buying a machine or hiring a worker costs  units, and there is no limit to the number of machines he can own or workers he can employ.
 * <p>
 * Karl wants to minimize the number of passes to obtain the required number of candies at the end of a day. Determine that number of passes.
 * <p>
 * For example, Karl starts with  machine and  workers. The cost to purchase or hire,  and he needs to accumulate  candies. He executes the following strategy:
 * <p>
 * Make  candies. Purchase two machines.
 * Make  candies. Purchase  machines and hire  workers.
 * Make  candies. Retain all  candies.
 * Make  candies. With yesterday's production, Karl has  candies.
 * It took  passes to make enough candies.
 * <p>
 * Function Description
 * <p>
 * Complete the minimumPasses function in the editor below. The function must return a long integer representing the minimum number of passes required.
 * <p>
 * minimumPasses has the following parameter(s):
 * <p>
 * m: long integer, the starting number of machines
 * w: long integer, the starting number of workers
 * p: long integer, the cost of a new hire or a new machine
 * n: long integer, the number of candies to produce
 * Input Format
 * <p>
 * A single line consisting of four space-separated integers describing the values of , , , and , the starting number of machines and workers, the cost of a new machine or a new hire, and the the number of candies Karl must accumulate to complete the level.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Return a long integer denoting the minimum number of passes required to accumulate at least  candies.
 * <p>
 * Sample Input
 * <p>
 * 3 1 2 12
 * Sample Output
 * <p>
 * 3
 * Explanation
 * <p>
 * Karl makes three passes:
 * <p>
 * In the first pass, he makes  candies. He then spends  of them hiring another worker, so  and he has one candy left over.
 * In the second pass, he makes  candies. He spends  of them on another machine and another worker, so  and  and he has  candies left over.
 * In the third pass, Karl makes  candies. Because this satisfies his goal of making at least  candies, we print the number of passes (i.e., ) as our answer.
 */
public class MakingCandies {

    static long minimumPasses(long m, long w, long p, long n) {


        long pass = 0, count = 0, num = 0, conCom = 0, sinCom = 0, w2 = 0, m2 = 0, count2 = 0, dif = 0;

        BigInteger obj = new BigInteger(String.valueOf(m));
        BigInteger obj1 = new BigInteger(String.valueOf(w));

        /*
         * To make it faster, I caught some specific cases which are obvious and
         * it could be solved with one equation
         */
        if (p >= n || m >= n || w >= n || (obj.multiply(obj1)).doubleValue() >= n) {
            //to get the total passes, just do n/(m*w)
            pass = (long) Math.ceil((double) n / (double) ((obj.multiply(obj1)).doubleValue()));
            return pass;
        }

        //I use just one while cycle
        do {

            /*
             * These lines are to manage very long numbers in Java
             * Tests that the page does, comes with very long numbers
             * */
            BigInteger wObj = new BigInteger(String.valueOf(m));
            BigInteger mObj = new BigInteger(String.valueOf(w));

            double multi = (wObj.multiply(mObj)).doubleValue();
            long divi = ((long) Math.ceil((double) (p - count) / (double) (multi)));

            BigInteger mulObj = (wObj.multiply(mObj));
            BigInteger divObj = new BigInteger(String.valueOf(divi));

            BigInteger mulDiv = mulObj.multiply(divObj);
            BigInteger countObj = new BigInteger(String.valueOf(count));


            //first, I check how many passes do I need to buy the first worker or machine

            if (count < p) {
                //Passess needed to buy whether a worker or machine or both
                pass = pass + (long) Math.ceil((double) (p - count) / (double) (multi));

                //countObj is the total of candies produced (BigInteger)
                countObj = countObj.add(mulDiv);
            }

            //if the countObj (total candies produced at this pass) is bigger or equal to "n"
            //then break the cycle and returns the passes else continue the execution
            BigInteger nObj = new BigInteger(String.valueOf(n));
            int res = countObj.compareTo(nObj);
            if (res == 0 || res == 1) break;

            //to use in other steps convert countObj to long type
            count = countObj.longValue();

            //System.out.println(pass+": "+w+"*"+m+" + countSin = "+count+" ===> "+n +" Se compra= "+num);


            /* Now I get how many passes left to achieve "n", without purchase
             * Because steps further I'll compare number of passes with purchase
             * vs number of passes without purchase
             */
            sinCom = (long) Math.ceil((double) (n - count) / (double) (m * w));

            //Save actual value of m,w and count in case number of passes without purchase was
            //less than number of passes with purchase
            m2 = m;
            w2 = w;
            count2 = count;

            //subtract P from count, in order to get the current total of candies produced with a purchase
            count = count - p;

            //Besides the last purchase, I determinate if it's possible to buy more than one workers or machines
            num = count / p;

            //If to buy more than one workers or machines is possible then buy it
            //therefore,  subtract The total of the purchases (num*p) from count
            //num*p = number of purchases (num) multiplied by cost of worker or machine (p)
            if (num > 0) count = count - (num * p);
            //plus one, because I haven't add the first purchase yet
            num = num + 1;

            //Then, this part of code is to decide whether to buy workers or machines
            /*Remember:
             * 	count = total of candies produced at this passe
             *  num = total of workers or machines that I can buy with the current count
             */

            /*
             *Note:
             *	The rule is: to buy more of the stuff which I have less, if they are equal
             *	add it wherever but one buy one.
             *	Example:
             *	3 * 4 = 12
             *	One purchase
             *	1 case:
             *		3 * 5 = 15
             *	2 case:
             *		4 * 4 = 16	        	 *
             */

            /*check if "num" is less or equal than the difference between "m" and "w"
             * if so, means that if I add "num" to the smaller number then It would be ok
             * because It would never be more than the greater one.
             */

            if (num <= (Math.abs(m - w))) {
                if (m <= w) m = m + num;
                else w = w + num;
            } else {
                /*Else, subtract the difference between m and w from "num"
                 * in order to add it to the smaller number of "m" and "w" to make it
                 * equal, and after this distribute the remainder between "m" and "w"
                 */

                //dif = remainder
                dif = num - (Math.abs(m - w));
                if (m <= w) m = w;
                else w = m;

                //Check if "dif" is even or odd
                if ((dif % 2) == 0) {
                    //if it is even add it proportional
                    m = m + (dif / 2);
                    w = w + (dif / 2);
                } else {
                    /*
                     * if it is odd, add it proportional less one, and that remainder one, add it
                     *to one of them (whatever).
                     */
                    m = m + ((dif - 1) / 2) + 1;
                    w = w + ((dif - 1) / 2);
                }
            }


            // Now I get how many passes left to achieve "n", with purchase
            conCom = (long) Math.ceil((double) (n - count) / (double) (m * w));


            //Now compare  (number of passes without purchase) vs (number of passes with purchase)
            /*if  (number of passes without purchase) is less than  (number of passes with purchase)
             * then don´t buy else buy it
             */
            if (sinCom < conCom) {
                /*if I can buy more than 1 worker or machine then I continue with the while
                 * else I calculate how many passes left (to achieve count >= n) to finish without
                 * purchase and break the cycle.
                 */
                if (num < 1) {
                    w = w2;
                    m = m2;
                    count = count2 + (w2 * m2);
                    pass = pass + 1;
                } else {
                    pass = pass + sinCom;
                    break;
                }

            }


        } while (count < n);


        return pass;
    }

    public static void main(String[] args) {

    }
}

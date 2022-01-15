package com.challenge.hackerrank.interviewprepkit.sorting;

import java.util.*;

/**
 * HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. If the amount spent by a client on a particular day is greater than or equal to  the client's median spending for a trailing number of days, they send the client a notification about potential fraud. The bank doesn't send the client any notifications until they have at least that trailing number of prior days' transaction data.
 * <p>
 * Given the number of trailing days  and a client's total daily expenditures for a period of  days, find and print the number of times the client will receive a notification over all  days.
 * <p>
 * For example,  and . On the first three days, they just collect spending data. At day , we have trailing expenditures of . The median is  and the day's expenditure is . Because , there will be a notice. The next day, our trailing expenditures are  and the expenditures are . This is less than  so no notice will be sent. Over the period, there was one notice sent.
 * <p>
 * Note: The median of a list of numbers can be found by arranging all the numbers from smallest to greatest. If there is an odd number of numbers, the middle one is picked. If there is an even number of numbers, median is then defined to be the average of the two middle values. (Wikipedia)
 * <p>
 * Function Description
 * <p>
 * Complete the function activityNotifications in the editor below. It must return an integer representing the number of client notifications.
 * <p>
 * activityNotifications has the following parameter(s):
 * <p>
 * expenditure: an array of integers representing daily expenditures
 * d: an integer, the lookback days for median spending
 * Input Format
 * <p>
 * The first line contains two space-separated integers  and , the number of days of transaction data, and the number of trailing days' data used to calculate median spending.
 * The second line contains  space-separated non-negative integers where each integer  denotes .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print an integer denoting the total number of times the client receives a notification over a period of  days.
 * <p>
 * Sample Input 0
 * <p>
 * 9 5
 * 2 3 4 2 3 6 8 4 5
 * Sample Output 0
 * <p>
 * 2
 * Explanation 0
 * <p>
 * We must determine the total number of  the client receives over a period of  days. For the first five days, the customer receives no notifications because the bank has insufficient transaction data: .
 * <p>
 * On the sixth day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which triggers a notification because : .
 * <p>
 * On the seventh day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which triggers a notification because : .
 * <p>
 * On the eighth day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which does not trigger a notification because : .
 * <p>
 * On the ninth day, the bank has  days of prior transaction data, , and a transaction median of  dollars. The client spends  dollars, which does not trigger a notification because : .
 * <p>
 * Sample Input 1
 * <p>
 * 5 4
 * 1 2 3 4 4
 * Sample Output 1
 * <p>
 * 0
 * There are  days of data required so the first day a notice might go out is day . Our trailing expenditures are  with a median of  The client spends  which is less than  so no notification is sent.
 *
 * @author shakil akhtar
 */
public class FraudulentActivityNotifications {

    static int activityNotifications(int[] expenditure, int d) {
        int[] count = new int[201];
        int result = 0;
        for (int i = 0; i < d; i++) {
            count[expenditure[i]]++;
        }
        for (int i = d; i < expenditure.length; i++) {
            int median = getMedian(count, d);
            if (median <= expenditure[i]) {
                result++;
            }
            count[expenditure[i - d]]--;
            count[expenditure[i]]++;
        }
        return result;
    }

    public static int getMedian(int[] count, int d) {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            if ((2 * sum) == d) {
                return (2 * i + 1);
            } else if ((2 * sum) > d) {
                return (i * 2);
            }
        }
        return 1;
    }


    //    public static int activityNotifications(int[] expenditure, int d){
//        int[] count = new int[201];
//        int result = 0;
//        for(int i = 0; i < d; i++){
//            count[expenditure[i]]++;
//        }
//        for(int i = d; i < expenditure.length; i++){
//            int median = getMedian(count, d);
//            if(median <= expenditure[i]){
//                result++;
//            }
//            count[expenditure[i-d]]--;
//            count[expenditure[i]]++;
//        }
//        return result;
//    }
    static int activityNotifications2(int[] expenditure, int d) {

        int count = 0;
        // create freq array as exp <= 200 always
        //maintain a queue to find on going and incoming exp
        //get median from freq array

        int freq[] = new int[201];
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < expenditure.length; i++) {
            while (i < d) {
                q.add(expenditure[i]);
                freq[expenditure[i]] = freq[expenditure[i]] + 1;
                i++;
            }


            float median = getMedian(freq, d);

            if (expenditure[i] >= 2 * median) {
                count++;
            }


            // removing out going element freq
            int elem = q.remove();
            freq[elem] = freq[elem] - 1;

            // adding incoming element to freq
            q.add(expenditure[i]);
            freq[expenditure[i]] = freq[expenditure[i]] + 1;
        }

        return count;
    }

//    private static float getMedian(int[] freq, int d) {
//        if (d % 2 == 1) {
//            int center = 0;
//            for (int i = 0; i < freq.length; i++) {
//                center = center + freq[i];
//
//                if (center > d / 2) {
//                    return i;
//                }
//            }
//        } else {
//            int count = 0;
//            int first = -1;
//            int second = -1;
//            for (int i = 0; i < freq.length; i++) {
//                count = count + freq[i];
//
//                if (count == d / 2) {
//                    first = i;
//                } else if (count > d / 2) {
//                    if (first < 0) first = i;
//                    second = i;
//
//                    return ((float) first + (float) second) / 2;
//                }
//            }
//        }
//        return 0f;
//    }

    public static void main(String[] args) {

    }
}

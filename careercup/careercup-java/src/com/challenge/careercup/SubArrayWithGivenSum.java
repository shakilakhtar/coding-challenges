package com.challenge.careercup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayWithGivenSum {

    public static void subarraySumFind(int[] nums, int k) {

        int count =0, sum =0;
        int start=0, end =-1;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0; i< nums.length; i++){

            sum += nums[i];

            if(map.containsKey(sum-k)){
                start = map.get(sum-k)+1;
                end = i;

                System.out.println(start + " " + end);
            }

            map.put(sum, i);
        }


    }

    public static int[] findSubSum(int[] a, int s) {
        List<Integer> resIds = new ArrayList<>();
        int t = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            t += a[i]; c++;
            if (t == s) {
                return new int []{b,c};
            } else if (t > s) {
                t = c = 0;
                i = b; // next loop will advance i
                b = b + 1;
            }
        }
        return null;
    }


    static int[] GetSumArray(int[] ar, int sum, int end, int[] sub)
    {
        if (sum == 0)
            return sub;
        if (sum < 0 || end < 0)
            return new int[0];
        if (sum < ar[end])
        {
            return GetSumArray(ar, sum, end - 1,sub);
        }
        else
        {
            sub[end] = ar[end];
            return GetSumArray(ar, sum - ar[end], end - 1, sub);
            //+ GetSumCount(ar, sum, end - 1);
        }
    }
    public static void main(String[] args) {

        int[] a={1,2,3,4,5,6,7,8};
        int [] sub=new int[a.length+1];
        //int [] res= findSubSum(a,3);
        subarraySumFind(a,10);
        int [] res=GetSumArray(a,10,a.length,sub);

    }
}

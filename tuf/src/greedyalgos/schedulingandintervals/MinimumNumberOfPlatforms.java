package greedyalgos.schedulingandintervals;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {
    public int findPlatform(int[] Arrival, int[] Departure) {
        //check work clock wise
        //sort both arrays
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int len = Arrival.length;
        //we have to find min platform that is the max we saw during
        int count = 1;
        int result = 1;
        //taking i for arrival idx
        //taking j for departure idx
        int i = 1;
        int j = 0;

        while (i < len && j < len){
            //check clock wise
            if (Arrival[i] <= Departure[j]){
                count++;
                i++;
            }else {
                count--;
                j++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
    public static void main(String[] args) {

    }
}

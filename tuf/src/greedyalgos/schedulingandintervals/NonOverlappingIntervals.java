package greedyalgos.schedulingandintervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public boolean compare(int[] v1, int[] v2){
        //compare end time of the intervals
        return v1[1] < v2[1];
    }
    public int MaximumNonOverlappingIntervals(int[][] intervals) {
        //sort intervals
       // Arrays.sort(intervals, compare);
        int len  = intervals.length;
        int count = 1;
        int lastEndingTime = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= lastEndingTime){
                count++;
                lastEndingTime = intervals[i][0];
            }
        }
        return len - count;
    }
    public static void main(String[] args) {

    }
}

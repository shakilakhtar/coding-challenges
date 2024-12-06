package greedyalgos.schedulingandintervals;

import java.util.Arrays;

public class ShortestJobFirst {
    public long solve(int[] bt) {
        Arrays.sort(bt);
        long waitTime = 0;
        long totalTime = 0;
        int len = bt.length;
        for (int i = 0; i < len; i++) {
            waitTime = waitTime + totalTime;
            totalTime = totalTime + bt[i];
        }
        long avgWaitingTime = waitTime / len;
        return avgWaitingTime;
    }
    public static void main(String[] args) {

    }
}

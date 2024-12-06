package greedyalgos.schedulingandintervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insertNewInterval(int[][] Intervals, int[] newInterval) {
        List<int[]> results =  new ArrayList<>();
        int i = 0;
        int len = Intervals.length;
        // Insert intervals before newInterval
        while (i < len && Intervals[i][1] < newInterval[0]) {
            results.add(Intervals[i]);
            i++;
        }
        // Merge overlapping intervals
        while (i < len && Intervals[i][0] <= newInterval[1]){
         /* Update the start time of newInterval to the
            minimum of its current start time and the
            start time of the current interval */
            newInterval[0] = Math.min(newInterval[0],Intervals[i][0]);
            /* Update the end time of newInterval to the
            maximum of its current end time and the
            end time of the current interval */
            newInterval[1] = Math.max(newInterval[1],Intervals[i][1]);
            i++;
        }
        //Insert the merged interval Add the merged interval to
        //the result list
        results.add(newInterval);
        //Insert remaining intervals after newInterval
        while (i < len){
            results.add(Intervals[i]);
            i++;
        }

        // Convert the result list to a 2D array and return
        return results.toArray(new int[results.size()][]);
    }
    public static void main(String[] args) {

    }
}

package greedyalgos.schedulingandintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInOneRoom {
    static class MeetingComparator  implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            //sort on the basis of end time
            return Integer.compare(o1[1],o2[1]);
        }
    }
    public int maxMeetings(int[] start, int[] end) {
       int len = start.length;
       //store meetings
        List<int[]> meetings = new ArrayList<>();
        //fill meetings from given details
        for (int i = 0; i < len; i++) {
            meetings.add(new int[]{start[i],end[i]});
        }
        //sort end time basis
        Collections.sort(meetings, new MeetingComparator());
        //end time of last selected meeting
        int limit = meetings.get(0)[1];
        //initialize count
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (meetings.get(i)[0] > limit){
                //update meeting time
                limit = meetings.get(i)[1];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {

    }
}

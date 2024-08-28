package arrays.faqs.hard;

public class MajorityElementI {
    //apply Moore's voting algorithm
    public static int majorityElement(int[] nums) {
        int count = 0;
        int mjLeader = nums[0];

        for (int i = 0; i <nums.length ; i++) {
            if (count == 0){
                mjLeader = nums[i];
            }
            if (nums[i] == mjLeader){
                count++;
            }else {
                count--;
            }
        }

        //check if the leader is majority element means
        //it should be greater than n/2 time in the array
        int leaderCount = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == mjLeader){
                leaderCount++;
            }
        }
        if (leaderCount > nums.length /2){
            return mjLeader;
        }

        return 0;
    }
    public static void main(String[] args) {
        int [] a = {1, 1, 1, 2, 1, 2};
        int me = majorityElement(a);
        System.out.print(me);
    }
}

package arrays.fundamentals;

public class LinearSearch {

    public int linearSearch(int nums[], int target) {
        //Your code goes here
        for (int i = 0; i <nums.length; i++) {
            if(nums[i] == target){
               return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}

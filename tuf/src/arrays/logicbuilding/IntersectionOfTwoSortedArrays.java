package arrays.logicbuilding;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> list  = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
              i++;
            }else if (nums2[j] < nums1[i]){
                j++;

            }
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] arr =  list.stream()
                     .mapToInt(Integer::intValue).toArray();

        return arr;
    }
    public static void main(String[] args) {

    }
}

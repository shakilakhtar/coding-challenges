package stacknqueue.faqs;

public class TrappingRainwater {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int total = 0;
        //start pointer on left from start and right from end
        int left = 0, right = height.length -1;

        while (left < right){
            if (height[left] <= height[right]){
                if (leftMax > height[left]){
                    //water can be stored
                    total += leftMax - height[left];
                }
                else {
                    leftMax = height[left];
                }
                //move left pointer
                left = left + 1;
            }
            else {
                if (rightMax > height[right]){
                    //water can be stored
                    total += rightMax - height[right];
                }else {
                   rightMax = height[right];
                }
                //move right pointer
                right = right - 1;
            }
        }
        return total;
    }
    public static void main(String[] args) {

    }
}

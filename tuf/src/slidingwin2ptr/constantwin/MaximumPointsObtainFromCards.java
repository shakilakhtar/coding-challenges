package slidingwin2ptr.constantwin;

public class MaximumPointsObtainFromCards {
    public int maxScore(int[] cardScore, int k) {
        int leftSum = 0;
        int maxSum = 0;
        int rightSum = 0;
        for (int i = 0; i < k ; i++) {
            leftSum = leftSum + cardScore[i];
            maxSum = leftSum;
        }
        int rightIdx = cardScore.length - 1;
        for (int j = k - 1; j >= 0; j--) {
            leftSum = leftSum - cardScore[j];
            rightSum = rightSum + cardScore[rightIdx];
            //set rightIdx
            rightIdx--;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {

    }
}

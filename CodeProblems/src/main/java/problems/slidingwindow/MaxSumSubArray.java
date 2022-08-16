package problems.slidingwindow;

//Return the maximum sum of all the SubArrays that fall within the given window size
public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] array = {4,2,1,7,8,1,2,8,1,0};
        System.out.println(findMaxSubArray(array, 4));
    }

    public static int findMaxSubArray(int[] array, int windowSize){
        int maxSum = Integer.MIN_VALUE;
        int runningTotal = 0;
        for (int i = 0; i < array.length; i++){
            runningTotal += array[i];
            if (i >= (windowSize - 1)) {
                maxSum = Math.max(maxSum, runningTotal);
                runningTotal -= array[i - (windowSize - 1)];
            }
        }
        return maxSum;
    }
}

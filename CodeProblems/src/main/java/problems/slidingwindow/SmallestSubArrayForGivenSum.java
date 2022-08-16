package problems.slidingwindow;

// Find a sub-array with the least number of elements that adds up to be greater than or equal to the target
public class SmallestSubArrayForGivenSum {

    public static void main(String[] args) {
        int[] input = {4,2,2,7,8,1,2,8,10};
        int target = 11;
        System.out.println(smallestSubArray(input, target));
    }

    public static int smallestSubArray(int[] array, int target){
        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;
        int[] subArray = new int[array.length];
        for (int windowEnd = 0 ; windowEnd < array.length; windowEnd++){
            currentWindowSum += array[windowEnd];
            while (currentWindowSum >= target){
                minWindowSize = Math.min(minWindowSize, (windowEnd + 1) - windowStart);
                currentWindowSum -= array[windowStart];
                windowStart++;
            }
        }
        return minWindowSize;
    }
}

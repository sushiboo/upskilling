package problems;

import java.util.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubArray(nums);
        System.out.println(max);
    }

    public static int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int current_sum = max_sum;
        int start = 0;
        int end = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > (current_sum + nums[i])){
                current_sum = nums[i];
                start = i;
            } else{
                current_sum = current_sum + nums[i];
            }

            if(current_sum > max_sum){
                max_sum = current_sum;
                end = i;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));
        return max_sum;
    }
}

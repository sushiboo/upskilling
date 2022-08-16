package problems;

import java.util.Arrays;

public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println("Binary Search 2: " + binarySearch2(nums));
        System.out.println("Binary Search 1: " + findMin(nums));
    }

    public static int findMin(int[] nums){
        int startIndex = 0;
        int endIndex = nums.length - 1;
        return binarySearch(nums, startIndex, endIndex, Integer.MAX_VALUE);
//        return binarySearch2(nums);
    }

    public static int binarySearch(int[] nums, int startIndex, int endIndex, int result){
        int midIndex = (int)Math.floor((double)(startIndex + endIndex) / 2);
        if(startIndex > endIndex) return result;
        if(nums[startIndex] < nums[endIndex]) return Math.min(nums[startIndex], result);
        result = Math.min(result, nums[midIndex]);
        if(nums[midIndex] >= nums[startIndex]){
            result = Math.min(result, binarySearch(nums, midIndex + 1, endIndex, result));
        }else{
            result = Math.min(result, binarySearch(nums, startIndex, midIndex -1, result));
        }
        return result;
    }

    public static int binarySearch2(int[] nums){
        int result = nums[0];
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while(startIndex <= endIndex){
            if(nums[startIndex] < nums[endIndex]){
                result = Math.min(nums[startIndex], result);
                break;
            }
            int midIndex = (startIndex + endIndex) / 2;
            result = Math.min(nums[midIndex], result);
            if(nums[midIndex] >= nums[startIndex]){
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return result;
    }
}

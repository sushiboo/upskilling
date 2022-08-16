package problems;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)) return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No match found!");
    }

    public static int[] twoSumWithTwoPointer(int[] nums, int target){
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int total = nums[left] + nums[right];
            if(total == target) return new int[]{nums[left], nums[right]};
            if(total < target) left++; else right--;
        }
        return new int[]{};
    }
}

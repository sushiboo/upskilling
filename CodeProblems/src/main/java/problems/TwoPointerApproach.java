package problems;

import java.util.*;

public class TwoPointerApproach {

    public static void main(String[] args) {
        int[][] arrays = {
//                {5,2,8,30,12},
//                {13,8,18,3, 6},
//                {12, 3, 5, 2, 31, 7},
//                {2,15,8,7,4,6},
//                { 1, 5, 7, -1, 5 }
                {5,7,7,8,8,10}
        };
        for (int[] array: arrays) {
//            System.out.println(Arrays.toString(array) + " : " + twoPointerApproach(array, 17));
//            System.out.println("twoSumWithTwoPointer: " + Arrays.toString(twoSumWithTwoPointer(array, 17)));
//            System.out.println("tripletsWithTwoPointers: " + Arrays.toString(tripletsWithTwoPointers(array, 17)));
//            System.out.println("countPairsWithGivenSum: " + getPairsCount(array, array.length, 6));
            System.out.println(Arrays.toString(getFirstAndLastPositionOfElementInSortedArray(array, 10)));
        }

    }

    public static boolean twoPointerApproach(int[] nums, int target){
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int total = nums[left] + nums[right];
            if(total == target) return true;
            if(total < target) left++; else right--;
        }
        return false;
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

    public static int[] tripletsWithTwoPointers(int[] nums, int target){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            int twoSumTarget = target - nums[i];
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] == twoSumTarget) return new int[]{nums[i], nums[left], nums[right]};
                if(nums[left] + nums[right] < twoSumTarget) left++; else right--;
            }
        }
        return new int[]{};
    }

    public static int countPairsWithGivenSum(int[] nums, int target){
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if(nums[left] + nums[right] == target) count++;
            if(nums[left] + nums[right] < target) left ++; else right--;
        }
        return count;
    }

    static int getPairsCount(int[] arr, int n, int sum)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(arr[i])) hm.put(arr[i], 0);
            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        int twice_count = 0;

        for (int i = 0; i < n; i++) {
            int complement = sum - arr[i];
            if (hm.get(complement) != null)
                twice_count += hm.get(complement);

            if (complement == arr[i])
                twice_count--;
        }
        return twice_count / 2;
    }

    static int[] getFirstAndLastPositionOfElementInSortedArray(int[] numArray, int target){
        int startIndex = 0;
        int endIndex = numArray.length - 1;
        int firstIndex = Integer.MAX_VALUE;
        int lastIndex = Integer.MIN_VALUE;
        while(startIndex <= endIndex){
            if(numArray[startIndex] == target) firstIndex = startIndex; else startIndex++;
            if(numArray[endIndex] == target) lastIndex = endIndex; else endIndex--;
            if(firstIndex != Integer.MAX_VALUE && lastIndex != Integer.MIN_VALUE) break;
        }
        return firstIndex == Integer.MAX_VALUE? new int[]{-1, -1}: new int[]{firstIndex, lastIndex};
    }

    static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++){
            if (i == 0 || (nums[i] != nums[i-1])){
                int low = i + 1, high = nums.length - 1, targetSum = -nums[i];
                while (low < high){
                    if (nums[low] + nums[high] == targetSum){
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] < targetSum) low++;
                    else high--;
                }
            }
        }
        return result;
    }
}

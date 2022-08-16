package problems.binarysearch;

public class SearchRotatingArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,7, 8, 9, 10, 0,1,2};
        int target = 1;
        System.out.println(findNumberInRotatingArray(nums, target));
    }
    public static int findNumberInRotatingArray(int[] nums, int target){
        int pivot = recursiveFindPivotingIndexOfRotatingArray(nums, 0, nums.length - 1);
        if(pivot == -1) return BinarySearch.recursiveBSForIndex(nums, target, 0, nums.length - 1);
        if(nums[pivot] == target) return pivot;
        if(target < nums[0]) return BinarySearch.recursiveBSForIndex(nums, target, pivot + 1, nums.length - 1);
        return BinarySearch.recursiveBSForIndex(nums, target, 0, pivot -1);
    }

    public static int findPivotingIndexOfRotatingArray(int[] nums){
        //If next number is greater than middle, the middle is the pivot
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex < endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            if (midIndex < endIndex && nums[midIndex] > nums[midIndex + 1]) return midIndex;
            else if (midIndex > 0 && nums[midIndex] < nums[midIndex - 1]) return midIndex -1;
            else if (nums[startIndex] >= nums[midIndex]) endIndex = midIndex - 1;
            else startIndex = midIndex + 1;
        }
        return -1;
    }

    public static int findPivotingIndexOfRotatingArrayWithDuplicates(int[] nums){
        //If next number is greater than middle, the middle is the pivot
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex < endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            if (midIndex < endIndex && nums[midIndex] > nums[midIndex + 1]) return midIndex;
            if (midIndex > 0 && nums[midIndex] < nums[midIndex - 1]) return midIndex -1;
            if (nums[midIndex] == nums[startIndex] && nums[midIndex] == nums[endIndex]){
                if(nums[startIndex] > nums[startIndex+1]) return startIndex;
                startIndex++;

                if(nums[endIndex] < nums[endIndex - 1]) return endIndex-1;
                endIndex--;
            }
            if (nums[startIndex] < nums[midIndex] || (nums[startIndex] == nums[midIndex] && nums[midIndex] > nums[endIndex])){
                startIndex = midIndex + 1;
            } else endIndex = midIndex - 1;
        }
        return -1;
    }

    public static int recursiveFindPivotingIndexOfRotatingArray(int[] nums, int startIndex, int endIndex){
        int midIndex = (startIndex + endIndex) / 2;
        if (midIndex < endIndex && nums[midIndex] > nums[midIndex + 1]) return midIndex;
        else if (midIndex > 0 && nums[midIndex] < nums[midIndex - 1]) return midIndex -1;
        else if (nums[startIndex] >= nums[midIndex])
            return recursiveFindPivotingIndexOfRotatingArray(nums, startIndex, midIndex - 1);
        else return recursiveFindPivotingIndexOfRotatingArray(nums, midIndex + 1, endIndex);
    }
}

package problems;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for(int i = 1; i < nums.length; i++){
            int tempMax = currentMax;
            currentMax = Math.max(Math.max((currentMax * nums[i]), nums[i]), (currentMin * nums[i]));
            currentMin = Math.min(Math.min((currentMin * nums[i]), nums[i]), (tempMax * nums[i]));
            maxProduct = Math.max(currentMax, maxProduct);
        }
        return maxProduct;
    }
}

package problems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(
                Arrays.toString(productExceptSelf(nums))
        );
    }

    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] outputArray = new int[n];
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        leftProducts[0]= 1;
        rightProducts[n - 1] = 1;

        for(int i = 1; i < n; i++){
            leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
        }
        System.out.println("Left Array: " + Arrays.toString(leftProducts));
        for (int i = n - 2; i >= 0; i--){
            rightProducts[i] = nums[i+1] * rightProducts[i+1];
        }
        System.out.println("Right Array: " + Arrays.toString(rightProducts));
        for (int i = 0; i < n; i++){
            outputArray[i] = leftProducts[i] * rightProducts[i];
        }
        return outputArray;
    }
}

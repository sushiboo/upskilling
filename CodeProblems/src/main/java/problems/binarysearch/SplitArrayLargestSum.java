package problems.binarysearch;

public class SplitArrayLargestSum {
    //Split the array into many number of sub-arrays consisting of m parts and get the sum of all those sub-arrays
    //Then return the smallest sum. https://www.youtube.com/watch?v=W9QJ8HaRvJQ&t=28s 3:33:48

    public static void main(String[] args) {
        int[] array = {7,2,5,10,8};
        System.out.println(returnMinimumSumOfSubArrays(array, 2));
    }

    public static int returnMinimumSumOfSubArrays(int[] array, int m){
        int start = 0;
        int end = 0;
        for (int num : array) {
            start = Math.max(num, start);
            end += num;
        }
        while (start < end){
            int mid = (start + end) / 2;
            int sum = 0;
            int pieces = 1;
            for (int num : array){
                if (sum + num > mid){
                    sum = num;
                    pieces++;
                } else sum += num;
            }
            if (pieces > m) start = mid +1;
            else end = mid;
        }
        return end;
    }
}

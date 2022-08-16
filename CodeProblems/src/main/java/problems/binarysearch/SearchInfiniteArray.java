package problems.binarysearch;

import java.util.Arrays;

public class SearchInfiniteArray {

    public static void main(String[] args) {
        int[] infiniteArray = new int[200];
        for (int i = 0; i < 200; i++){
            infiniteArray[i] = i + 2;
        }
        int target = 91;
        System.out.println(searchNumberInAnInfiniteArray(infiniteArray, target));
    }

    public static int searchNumberInAnInfiniteArray(int[] infiniteArray, int target){
        int[] searchIndex = returnIndexRangeForTargetNumberFromInfiniteArray(infiniteArray, target);
        System.out.println(Arrays.toString(searchIndex));
        int startIndex = searchIndex[0];
        int endIndex = searchIndex[1];
        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if(target > infiniteArray[midIndex]) startIndex = midIndex + 1;
            else if (target < infiniteArray[midIndex]) endIndex = midIndex - 1;
            else return midIndex;
        }
        return -1;
    }

    public static int[] returnIndexRangeForTargetNumberFromInfiniteArray(int[] numArray, int target, int start, int end){
        if(target >= numArray[start] && target <= numArray[end]) return new int[]{start, end};
        return returnIndexRangeForTargetNumberFromInfiniteArray(
                numArray, target, end + 1, end * 2
        );
    }

    public static int[] returnIndexRangeForTargetNumberFromInfiniteArray(int[] numArray, int target){
        int start = 0;
        int end = 1;
        while(target > numArray[end]) {
            int newStart = end;
            end = end * 2;
            start = newStart;
            System.out.println(Arrays.toString(new int[]{start, end}));
        };
        return new int[]{start, end};
    }
}

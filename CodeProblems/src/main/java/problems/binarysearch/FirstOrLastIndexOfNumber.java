package problems.binarysearch;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class FirstOrLastIndexOfNumber {

    public static void main(String[] args) {
        int[] numArray = {1,2,2};
        int target = 2;
        System.out.println(Arrays.toString(getFirstAndLastPositionOfElementInSortedArray(numArray, target)));
    }

    public static int[] getFirstAndLastPositionOfElementInSortedArray(int[] numArray, int target){
        int firstIndex = getFirstOrLastIndexOfTargetNumberInArray(numArray, target, true);
        int lastIndex = getFirstOrLastIndexOfTargetNumberInArray(numArray, target, false);
        return new int[]{firstIndex, lastIndex};
    }

    public static int getFirstOrLastIndexOfTargetNumberInArray(int[] numArray, int target, boolean isFindFirst){
        int startIndex = 0;
        int endIndex = numArray.length - 1;
        int foundIndex = -1;
        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if(target < numArray[midIndex]) endIndex = midIndex - 1;
            else if (target > numArray[midIndex]) startIndex = midIndex + 1;
            else {
                foundIndex = midIndex;
                if (isFindFirst){
                    endIndex = midIndex - 1;
                }else{
                    startIndex = midIndex + 1;
                }
            }
        }
        return foundIndex;
    }
}

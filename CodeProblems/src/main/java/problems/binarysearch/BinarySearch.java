package problems.binarysearch;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        int target = 10;
        System.out.println("recursiveBS: " + recursiveBS(numbers, target, startIndex, endIndex));
        System.out.println("recursiveBSForIndex: " + recursiveBSForIndex(numbers, target, startIndex, endIndex));
        System.out.println("simpleBS: " + simpleBS(numbers, target));
        System.out.println("simpleBS v2: " + simpleBS(numbers, target, startIndex, endIndex));
        System.out.println("orderAgnosticBS: " + orderAgnosticBS(numbers, target, startIndex, endIndex));
    }

    public static boolean recursiveBS(int[] array, int target, int startIndex, int endIndex){
        if(startIndex > endIndex ) return false;
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        if(array[midIndex] == target) return true;
        if(array[midIndex] > target) return recursiveBS(array, target, startIndex, midIndex - 1);
        else return recursiveBS(array, target, midIndex + 1, endIndex);
    }

    public static int recursiveBSForIndex(int[] array,  int target, int startIndex, int endIndex){
        if(startIndex > endIndex) return -1;
        int midIndex = (startIndex + endIndex) /2;
        if (array[midIndex] == target) return midIndex;
        if(target > array[midIndex]) return recursiveBSForIndex(array, target, midIndex + 1, endIndex);
        else return recursiveBSForIndex(array, target, startIndex, endIndex - 1);
    }

    public static int simpleBS(int[] numArray, int target){
        int startIndex = 0;
        int endIndex = numArray.length - 1;
        while(startIndex <= endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            if(target > numArray[midIndex]) startIndex = midIndex + 1;
            else if(target < numArray[midIndex]) endIndex = midIndex - 1;
            else return midIndex;
        }
        return -1;
    }

    public static int simpleBS(int[] numArray, int target, int startIndex, int endIndex){
        while(startIndex <= endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            if(target > numArray[midIndex]) startIndex = midIndex + 1;
            else if(target < numArray[midIndex]) endIndex = midIndex - 1;
            else return midIndex;
        }
        return -1;
    }

    public static int orderAgnosticBS(int[] numArray, int target, int startIndex, int endIndex){
        boolean isAscending = numArray[startIndex] < numArray[endIndex];
        while(startIndex <= endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            if(target > numArray[midIndex])
                if (isAscending) startIndex = midIndex + 1; else endIndex = midIndex - 1;
            else if(target < numArray[midIndex])
                if (isAscending) endIndex = midIndex - 1; else startIndex = midIndex + 1;
            else return midIndex;
        }
        return -1;
    }
}

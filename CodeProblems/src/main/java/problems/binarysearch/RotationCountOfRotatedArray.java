package problems.binarysearch;

public class RotationCountOfRotatedArray {

    public static void main(String[] args) {
        int[] array = {4,5,6,7,0,1,2};
        System.out.println(findRotationCountOfRotatedArray(array));
    }

    public static int findRotationCountOfRotatedArray(int[] array){
        int pivot = findPivotOfRotatedArray(array);
        return pivot + 1;
    }

    public static int findPivotOfRotatedArray (int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex < endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            if (midIndex+1 < endIndex && array[midIndex] > array[midIndex+1]) return midIndex;
            if (midIndex-1 > startIndex && array[midIndex] < array[midIndex-1]) return midIndex-1;
            if (array[startIndex] < array[midIndex]) startIndex = midIndex + 1;
            else endIndex = midIndex - 1;
        }
        return -1;
    }
}

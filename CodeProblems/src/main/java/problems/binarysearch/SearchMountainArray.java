package problems.binarysearch;

public class SearchMountainArray {

    public static int findPeakNumbersIndexOfMountainArray(int[] mountainArray){
        int startIndex = 0;
        int endIndex = mountainArray.length - 1;
        while(startIndex < endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            if(mountainArray[midIndex + 1] > mountainArray[midIndex]){
                startIndex = midIndex + 1;
            }else if (mountainArray[midIndex + 1] < mountainArray[midIndex]){
                endIndex = midIndex;
            }
        }
        return startIndex;
    }

    public static int findTargetValuesIndexInMountainArrayTest(){
        int[] mountainArray = {0,1,2,4,2,1};
        int target = 3;
        int peakNumbersIndex = findPeakNumbersIndexOfMountainArray(mountainArray);
        if (target == mountainArray[peakNumbersIndex]) return peakNumbersIndex;
        int leftSearch = BinarySearch.orderAgnosticBS(mountainArray, target, 0, peakNumbersIndex);
        if (leftSearch != -1) return leftSearch;
        return BinarySearch.orderAgnosticBS(mountainArray, target, peakNumbersIndex + 1, mountainArray.length -1);
    }
}

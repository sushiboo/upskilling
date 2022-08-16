package problems.binarysearch;

public class CeilingOrFloorOfTheNumber {

    public static void main(String[] args) {
        int[] numbers = {2,3,5,9,14,16,18};
        char[] chars = {'c','f','j'};
        System.out.println("Ceiling: " + binarySearchNumberEqualOrGreaterThanTarget(numbers, 10));
        System.out.println("Floor: " + binarySearchNumberEqualOrLesserThanTarget(numbers, 10));
        System.out.println("Ceiling Character: " + getCharacterEqualOrGreaterThanTarget(chars, 'g'));
    }

    //Find the ceiling of the number :-
    public static int binarySearchNumberEqualOrGreaterThanTarget(int[] array, int target){
        int startIndex = 0;
        int endIndex = array.length - 1;
        if (target > array[endIndex]) return -1;
        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if(array[midIndex] == target) return array[midIndex];
            if(array[midIndex] < target) {startIndex = midIndex +1;} else endIndex = midIndex - 1;
        }
        return array[startIndex];
    }

    //Find the floor of the number :-
    public static int binarySearchNumberEqualOrLesserThanTarget(int[] array, int target){
        int startIndex = 0;
        int endIndex = array.length - 1;
        if (target < array[startIndex]) return -1;
        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if(array[midIndex] == target) return array[midIndex];
            if(array[midIndex] < target) {startIndex = midIndex +1;} else endIndex = midIndex - 1;
        }
        return array[endIndex];
    }

    //Find the ceiling of the target character in an array
    public static char getCharacterEqualOrGreaterThanTarget(char[] chars, char target){
        int startIndex = 0;
        int endIndex = chars.length - 1;
        while(startIndex <= endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            if(target >= chars[midIndex]) startIndex = midIndex + 1;
            else endIndex = midIndex - 1;
        }
        return chars[startIndex % chars.length];
    }
}

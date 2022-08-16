package problems.binarysearch;

import java.util.Arrays;

//Time complexity: O(log(n) + log(m))
public class SearchSortedMatrix {

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(search(arr, 9)));
    }

    //search in the row provided between the columns provided
    static int[] binarySearch(int[][] matrix, int target, int row, int colStart, int colEnd){
        while (colStart <= colEnd){
            int mid = colStart + (colEnd - colStart) / 2;
            if (matrix[row][mid] == target) return new int[]{row, mid};
            if (target > matrix[row][mid]) colStart = mid + 1;
            else colEnd = mid - 1;
        }
        return new int[]{-1, -1};
    }

    public static int[] search(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;

        if (row == 1) return binarySearch(matrix, target, 0, 0, col - 1);

        int rowStart = 0;
        int rowEnd = row - 1;
        int colMid = col/2;

        // Run loop until only 2 rows are remaining
        while (rowStart < (rowEnd - 1)){
            int mid = rowStart + (rowEnd - rowStart) / 2;
            System.out.println("mid: " + mid );
            System.out.println("rowStart: " + rowStart);
            if (matrix[mid][colMid] == target)
                return new int[]{mid, colMid};
            if (matrix[mid][colMid] < target) rowStart = mid;
            else rowEnd = mid;
        }
        System.out.println("Loop Complete!");

        // Now we have 2 rows remaining
        // Check if the target is in the middle
        if (matrix[rowStart][colMid] == target) return new int[]{rowStart, colMid};
        if (matrix[rowStart + 1][colMid] == target)
            return new int[]{rowStart + 1, colMid};

        System.out.println("Row start: " + rowStart + ", Row end: " + rowEnd + ", Col mid: " + colMid);

        // Search in first half
        if (target <= matrix[rowStart][colMid-1]) {
            System.out.println("First cause triggered!");
            return binarySearch(matrix, target, rowStart, 0, colMid - 1);
        }

        // Search second half of the same row
        if (target >= matrix[rowStart][colMid + 1] && target <= matrix[rowStart][col - 1]) {
            System.out.println("Second cause triggered!");
            return binarySearch(matrix, target, rowStart, colMid + 1, col - 1);
        }

        // Search first half of the second row
        if (target <= matrix[rowStart + 1][colMid-1]){
            System.out.println("Third cause triggered!");
            return binarySearch(matrix, target, rowStart + 1, 0, colMid - 1);
        }
        else {
            System.out.println("Else cause triggered!");
            return binarySearch(matrix, target, rowStart + 1, colMid + 1, col - 1);
        }


        // Search second half of the second row
//        if (target >= matrix[rowStart + 1][colMid + 1] && target <= matrix[rowStart + 1][col - 1])
//            return binarySearch(matrix, target, rowStart + 1, colMid + 1, col - 1);

//        return new int[]{-1,-1};
    }
}

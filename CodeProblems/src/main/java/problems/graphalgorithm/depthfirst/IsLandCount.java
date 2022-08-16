package problems.graphalgorithm.depthfirst;

import problems.graphalgorithm.Graph;

import java.util.HashSet;
import java.util.Map;

// Count the number of Island on the 2d grid or find the smallest island
public class IsLandCount {

    public static void main(String[] args) {
        Character[][] grid = Graph.getIslandGraph();
//        System.out.println(getNumberOfIslands(grid));
        System.out.println(findMinimumIslandSize(grid));
    }

    public static int getNumberOfIslands(Character[][] grid){
        HashSet<String> visited = new HashSet<>();
        int count = 0;
        for (int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if (explore(grid, row, column, visited)) count += 1;
            }
        }
        return count;
    }

    public static boolean explore (Character[][] grid, int row, int column, HashSet<String> visited){
        boolean rowInbounds = row >= 0 && row < grid.length;
        boolean columnInbounds = column >= 0 && column < grid[0].length;
        if (!rowInbounds || !columnInbounds) return false;

        if (grid[row][column] == 'W') return false;

        String position = row + ", " + column;
        if (visited.contains(position)) return false;
//        System.out.println(position);
        visited.add(position);

        explore(grid, row-1, column, visited); //Up
        explore(grid, row + 1, column, visited); //Down
        explore(grid, row, column - 1, visited); //Left
        explore(grid, row, column + 1, visited); //Right

        return true;
    }

    public static int findMinimumIslandSize(Character[][] grid){
        HashSet<String> visited = new HashSet<>();
        int minimumSize = Integer.MAX_VALUE;
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                int size = exploreForSize(grid, r, c, visited);
                minimumSize = size != 0 ? Math.min(size, minimumSize) : minimumSize;
            }
        }
        return minimumSize;
    }

    public static int exploreForSize(Character[][] grid, int row, int column, HashSet<String> visited){
        boolean rowsInbound = row >= 0 && row < grid.length;
        boolean columnsInbound = column >= 0 && column < grid[0].length;
        if (!rowsInbound || !columnsInbound) return 0;

        if (grid[row][column] == 'W') return 0;

        String position = row + ", " + column;
        if (visited.contains(position)) return 0;
        visited.add(position);
        int size = 1;

        size += exploreForSize(grid, row - 1, column, visited); //Up
        size += exploreForSize(grid, row + 1, column, visited); //Down
        size += exploreForSize(grid, row, column - 1, visited); //Left
        size += exploreForSize(grid, row, column + 1, visited); //Right

        return size;
    }
}

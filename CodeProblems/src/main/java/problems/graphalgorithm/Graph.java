package problems.graphalgorithm;

import java.util.*;

public class Graph {
    public static Map<Character, Character[]> prepareGraph(){
        Map<Character, Character[]> graph = new HashMap<>();
        graph.put('a', new Character[] {'c', 'b'});
        graph.put('b', new Character[] {'d'});
        graph.put('c', new Character[] {'e'});
        graph.put('d', new Character[] {'f'});
        graph.put('e', new Character[] {});
        graph.put('f', new Character[] {});
        return graph;
    }

    public static Map<Character, Character[]> buildGraphUsingEdges(char[][] edges){
        Map<Character, Character[]> graph = new HashMap<>();
        for (char[] edge : edges){
            char a = edge[0];
            char b = edge[1];
            graph.putIfAbsent(a, new Character[]{});
            graph.putIfAbsent(b, new Character[]{});
            graph.put(a, append(graph.get(a),b));
            graph.put(b, append(graph.get(b),a));
        }
        return graph;
    }

    public static Character[][] getIslandGraph(){
        return new Character[][]{
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'W', 'L', 'W'},
                {'W', 'W', 'L', 'L', 'W'},
                {'L', 'W', 'W', 'L', 'L'},
                {'L', 'L', 'W', 'W', 'W'}
        };
    }

    static <T> T[] append(T[] arr, T element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }

    public static char[][] prepareEdgesSetOne(){
        return new char[][]{
                {'i', 'j'},
                {'k', 'i'},
                {'m', 'k'},
                {'k', 'l'},
                {'o', 'n'}
        };
    }

    public static char[][] prepareEdgesSetTwo(){
        return new char[][]{
                {'w', 'x'},
                {'x', 'y'},
                {'z', 'y'},
                {'z', 'v'},
                {'w', 'v'}
        };
    }

    public static char[][] prepareEdgesSetThree(){
        return new char[][]{
                {'a', 'c'},
                {'a', 'b'},
                {'c', 'b'},
                {'c', 'd'},
                {'b', 'd'},
                {'e', 'd'},
                {'g', 'f'}
        };
    }
}

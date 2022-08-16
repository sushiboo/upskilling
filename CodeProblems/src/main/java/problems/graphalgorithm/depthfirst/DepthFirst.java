package problems.graphalgorithm.depthfirst;

import problems.graphalgorithm.Graph;

import java.util.*;

public class DepthFirst {

    public static void main(String[] args) {
        Map<Character, Character[]> graph = Graph.prepareGraph();
//        depthFirstPrint(graph, 'a');
//        System.out.println("RECURSIVE DF PRINT!");
//        recursiveDepthFirstPrint(graph, 'a');

//        System.out.println("RECURSIVE DF SEARCH!");
//        System.out.println(recursiveDepthFirstHasPath(graph, 'a', 'e'));

//        Map<Character, Character[]> graphWithEdges = Graph.buildGraphUsingEdges(Graph.prepareEdgesSetOne());
//        System.out.println(recursiveHasPathForCyclicGraph(graphWithEdges, 'j', 'm', new HashSet<>()));
//        System.out.println("HAS PATH FOR CYCLIC GRAPHS!");
//        System.out.println(hasPathForCyclicGraph(graphWithEdges, 'j', 'm', new HashSet<>()));

//        System.out.println(findCountOfConnectedComponents());
        System.out.println(findLargestNumberOfConnectedNodes());
    }
    public static void depthFirstPrint(Map<Character, Character[]> graph, char source){
        Stack<Character> stack = new Stack<>();
        stack.push(source);
        while (stack.size() > 0){
            System.out.println(Arrays.toString(stack.toArray()));
            char current = stack.pop();
            System.out.println("Popped: " + current);
            for (char neighbour : graph.get(current)) stack.push(neighbour);
        }
    }

    public static void recursiveDepthFirstPrint(Map<Character,Character[]> graph, char source){
        System.out.println(source);
        for (char neighbour : graph.get(source))
            recursiveDepthFirstPrint(graph, neighbour);
    }

    public static boolean recursiveDepthFirstHasPath(Map<Character, Character[]> graph, char source, char destination){
        System.out.println("source: " + source + ", destination: " + destination);
        if(source == destination) return true;
        for (char neighbour : graph.get(source)){
            if (recursiveDepthFirstHasPath(graph, neighbour, destination)) return true;
        }
        return false;
    }

    public static boolean recursiveHasPathForCyclicGraph(Map<Character, Character[]> graph, char src, char dst, HashSet<Character> visited){
        if(src == dst) return true;
        if (visited.contains(src)) return false;
        visited.add(src);
        for (char neighbour : graph.get(src)){
            if(recursiveHasPathForCyclicGraph(graph, neighbour, dst, visited)) return true;
        }
        return false;
    }

    public static boolean hasPathForCyclicGraph(Map<Character, Character[]> graph, char src, char dst, HashSet<Character> visited){
        Stack<Character> stack = new Stack<>();
        stack.push(src);
        while (stack.size() > 0){
            System.out.println(Arrays.toString(stack.toArray()));
            char current = stack.pop();
            System.out.println("Popped: " + current);
            if (current == dst) return true;
            if (visited.contains(current)) {
                System.out.println("Contains Current: " + current);
                continue;
            }
            visited.add(current);
            for(char neighbour : graph.get(current)) stack.push(neighbour);
        }
        return false;
    }

    public static int findCountOfConnectedComponents(){
        Map<Character, Character[]> graph = Graph.buildGraphUsingEdges(Graph.prepareEdgesSetOne());
        HashSet<Character> visited = new HashSet<>();
        int count = 0;
        for (char key : graph.keySet()){
            if (recursiveCountConnectedComponent(graph, key, visited)) count++;
        }
        return count;
    }

    public static boolean recursiveCountConnectedComponent(Map<Character, Character[]> graph, char src, HashSet<Character> visited){
        if (visited.contains(src)) return false;
        visited.add(src);
        for (char neighbour : graph.get(src)){
            recursiveCountConnectedComponent(graph, neighbour, visited);
        }
        return true;
    }

    public static int findLargestNumberOfConnectedNodes(){
        Map<Character, Character[]> graph = Graph.buildGraphUsingEdges(Graph.prepareEdgesSetOne());
        HashSet<Character> visited = new HashSet<>();
        int count = 0;
        for (char key : graph.keySet()){
            int tmpSize = recursiveReturnNumberOfConnectedNodes(graph, key, visited);
            count = Math.max(count, tmpSize);
        }
        return count;
    }

    public static int recursiveReturnNumberOfConnectedNodes(Map<Character, Character[]> graph, char src, HashSet<Character> visited){
        if (visited.contains(src)) return 0;
        visited.add(src);
        int size = 1;
        for (char neighbour : graph.get(src)){
            size += recursiveReturnNumberOfConnectedNodes(graph, neighbour, visited);
        }
        return size;
    }

    public static int returnNumberOfConnectedNodes(Map<Character, Character[]> graph, char src, HashSet<Character> visited){
        Stack<Character> stack = new Stack<>();
        stack.push(src);
        int count = 0;
        while(stack.size() > 0){
            char current = stack.pop();
            if (visited.contains(current)) continue;
            visited.add(current);
            count++;
            for(char neighbour : graph.get(current)) stack.push(neighbour);
        }
        return count;
    }
}

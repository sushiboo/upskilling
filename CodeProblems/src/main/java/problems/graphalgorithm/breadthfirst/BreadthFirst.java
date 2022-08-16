package problems.graphalgorithm.breadthfirst;

import problems.graphalgorithm.Graph;

import java.util.*;

public class BreadthFirst {
    public static void main(String[] args) {
        Map<Character, Character[]> graph = Graph.prepareGraph();
//        breadthFirstPrint(graph, 'a');
//        System.out.println("BREADTH FIRST HAS PATH!");
//        System.out.println(breadthFirstHasPath(graph, 'a', 'e'));
        Map<Character, Character[]> graphWithEdges = Graph.buildGraphUsingEdges(Graph.prepareEdgesSetThree());
//        System.out.println("BREADTH FIRST HAS PATH FOR CYCLIC GRAPHS!");
//        System.out.println(hasPathOnCyclicGraph(graphWithEdges, 'j', 'l'));
        for (char key: graphWithEdges.keySet()) System.out.println(key + ": " + Arrays.toString(graphWithEdges.get(key)));
        System.out.println(findShortestPathWithSubArray(graphWithEdges, 'b', 'e'));
    }

    public static void breadthFirstPrint(Map<Character, Character[]> graph, char source){
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);
        while (queue.size() > 0){
            System.out.println(Arrays.toString(queue.toArray()));
            char current = queue.remove();
            System.out.println("Removed: " + current);
            queue.addAll(Arrays.asList(graph.get(current)));
        }
    }

    public static boolean breadthFirstHasPath(Map<Character, Character[]> graph, char source, char destination){
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);
        while (queue.size() > 0){
            System.out.println(Arrays.toString(queue.toArray()));
            char current = queue.remove();
            System.out.println("Current: " + current + ", Destination: " + destination);
            if (current == destination) return true;
            queue.addAll(Arrays.asList(graph.get(current)));
        }
        return false;
    }

    public static boolean hasPathOnCyclicGraph(Map<Character, Character[]> graph, char src, char dst){
        HashSet<Character> visitedNodes = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        queue.add(src);
        while(queue.size() > 0){
            System.out.println(Arrays.toString(queue.toArray()));
            char current = queue.remove();
            System.out.println("Current: " + current + ", Destination: " + dst);
            if (current == dst) return true;
            if (visitedNodes.contains(current)) {
                System.out.println("Contains Current: " + current);
                continue;
            }
            visitedNodes.add(current);
            queue.addAll(Arrays.asList(graph.get(current)));
        }
        return false;
    }

    public static int findShortestPathWithSubArray(Map<Character,Character[]> graph, char src, char dst){
        Queue<Object[][]> queue = new LinkedList<>();
        queue.add(new Object[][]{{src, 0}});
        HashSet<Character> visitedNodes = new HashSet<>();
        while (queue.size() > 0){
            Object[] current = queue.remove()[0];
            char currentNode = (char) current[0];
            int currentCount = (int) current[1];
            System.out.println(currentNode + " : " + currentCount);
            if (currentNode == dst) return currentCount;
            for (char neighbour : graph.get(currentNode)){
                if (!visitedNodes.contains(neighbour)) {
                    visitedNodes.add(currentNode);
                    queue.add(new Object[][]{{neighbour, currentCount+1}});
                }
            }
        }
        return -1;
    }
}

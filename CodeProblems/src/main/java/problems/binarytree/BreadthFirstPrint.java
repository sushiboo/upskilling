package problems.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstPrint {

    public static void main(String[] args) {
        Node[] treeNodes = BinaryTree.buildBinaryTree();
        System.out.println(printNodes(treeNodes[0]));
    }

    public static List<Character> printNodes(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Character> results = new ArrayList<>();
        while (queue.size() > 0){
            Node currentNode = queue.remove();
            results.add(currentNode.getVal());
            if (currentNode.getRight() != null) queue.add(currentNode.getRight());
            if (currentNode.getLeft() != null) queue.add(currentNode.getLeft());
        }
        return results;
    }
}

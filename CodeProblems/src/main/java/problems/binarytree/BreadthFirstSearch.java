package problems.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Node[] binaryTree = BinaryTree.buildBinaryTree();
        System.out.println(searchNode(binaryTree[0], 'g'));
    }

    public static boolean searchNode (Node root, char target){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        if (root.getVal() == target) return true;
        while (queue.size() > 0){
            Node currentNode = queue.remove();
            System.out.println(currentNode.getVal());
            if (currentNode.getVal() == target) return true;
            if (currentNode.getLeft() != null) queue.add(currentNode.getLeft());
            if (currentNode.getRight() != null) queue.add(currentNode.getRight());
        }
        return false;
    }
}

package problems.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTreeSum {
    public static void main(String[] args) {
        IntNode[] intNodes = BinaryTree.buildIntBinaryTree();
        System.out.println(returnSumOfNodeValues(intNodes[0]));
    }

    public static int returnSumOfNodeValues(IntNode root){
        if (root == null) return 0;
        Queue<IntNode> queue = new LinkedList<>();
        queue.add(root);
        int totalSum = 0;
        while (queue.size() > 0){
            IntNode current = queue.remove();
            totalSum += current.getVal();
            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }
        return totalSum;
    }
}

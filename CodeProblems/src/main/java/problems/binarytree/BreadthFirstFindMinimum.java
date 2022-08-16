package problems.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFindMinimum {
    public static void main(String[] args) {
        IntNode[] intNodes = BinaryTree.buildIntBinaryTreeV2();
        System.out.println(findMinimum(intNodes[0]));
    }

    public static int findMinimum(IntNode root){
        if (root == null) return 0;
        Queue<IntNode> queue = new LinkedList<>();
        queue.add(root);
        int currentMinimum = Integer.MAX_VALUE;
        while (queue.size() > 0){
            IntNode current = queue.remove();
            currentMinimum = Math.min(currentMinimum, current.getVal());
            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }
        return currentMinimum;
    }
}

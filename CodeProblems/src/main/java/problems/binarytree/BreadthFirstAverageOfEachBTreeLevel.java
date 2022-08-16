package problems.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstAverageOfEachBTreeLevel {
    public static void main(String[] args) {
        IntNode[] intNodes = BinaryTree.buildIntBinaryTreeV4();
        averageOfEachLevel(intNodes[0]);
    }

    public static void averageOfEachLevel(IntNode root){
        Queue<IntNode> queue = new LinkedList<>();
        queue.add(root);
        int sum, count;

        while (queue.size() > 0){
            sum = 0;
            count = 0;
            Queue<IntNode> temp = new LinkedList<>();
            while (queue.size() > 0){
                IntNode current = queue.remove();
                sum += current.getVal();
                count++;
                if (current.getLeft() != null) temp.add(current.getLeft());
                if (current.getRight() != null) temp.add(current.getRight());
            }
            queue = temp;
            System.out.print((sum * 1.0 / count) + ", ");
        }
    }
}

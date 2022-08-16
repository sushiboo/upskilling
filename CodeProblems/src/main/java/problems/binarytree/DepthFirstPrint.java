package problems.binarytree;

import org.apache.commons.lang3.ArrayUtils;
import problems.utilities.ArrayUtils2;

import java.util.*;

public class DepthFirstPrint {

    public static void main(String[] args) {
        Node[] binaryTreeNodes = BinaryTree.buildBinaryTree();
//        System.out.println(Arrays.toString(printNodes(binaryTreeNodes)));
        System.out.println(recursivePrintNodes(binaryTreeNodes[0]));
        System.out.println(Arrays.toString(recursivePrintNodesTwo(binaryTreeNodes[0])));
    }

    public static Character[] printNodes(Node[] nodes){
        if (nodes == null) return new Character[]{};
        Stack<Node> stack = new Stack<>();
        stack.add(nodes[0]);
        int i = 0;
        Character[] result = new Character[nodes.length];

        while (stack.size() > 0){
            Node currentNode = stack.pop();
            result[i] = currentNode.getVal();
            i++;
            if (currentNode.getLeft() != null) stack.push(currentNode.getLeft());
            if (currentNode.getRight() != null) stack.push(currentNode.getRight());
        }
        return result;
    }

    public static String recursivePrintNodes(Node src){
        if (src == null) return "";
        return src.getVal() + ", " + recursivePrintNodes(src.getLeft()) + recursivePrintNodes(src.getRight());
    }

    public static Character[] recursivePrintNodesTwo (Node src){
        if (src == null) return new Character[]{};
        return ArrayUtils.addAll(
                new Character[]{src.getVal()},
                ArrayUtils.addAll(
                        recursivePrintNodesTwo(src.getLeft()), recursivePrintNodesTwo(src.getRight())
                )
        );
    }
}

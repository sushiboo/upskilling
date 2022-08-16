package problems.binarytree;

public class DepthFirstFindMinimum {
    public static void main(String[] args) {
        IntNode[] intNodes = BinaryTree.buildIntBinaryTree();
        System.out.println(findMinimum(intNodes[0]));
    }

    public static int findMinimum(IntNode root){
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(
                root.getVal(),
                Math.min(findMinimum(root.getLeft()), findMinimum(root.getRight()))
        );
    }
}

package problems.binarytree;

public class DepthFirstTreeSum {
    public static void main(String[] args) {
        IntNode[] intNodes = BinaryTree.buildIntBinaryTree();
        System.out.println(returnSumOfNodeValue(intNodes[0]));
    }

    public static int returnSumOfNodeValue(IntNode root){
        if (root == null) return 0;
        return root.getVal() + returnSumOfNodeValue(root.getLeft()) + returnSumOfNodeValue(root.getRight());
    }
}

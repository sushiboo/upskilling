package problems.binarytree;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Node[] binaryTree = BinaryTree.buildBinaryTree();
        System.out.println(search(binaryTree[0], 'g'));
    }

    public static boolean search (Node root, char target){
        if (root == null) return false;
        System.out.println(root.getVal());
        if (root.getVal() == target) return true;
        return search(root.getLeft(), target) || search(root.getRight(), target);
    }
}

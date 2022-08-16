package problems.binarytree;

import com.sun.security.jgss.GSSUtil;
import org.w3c.dom.Node;

public class DepthFirstMaxRootToLeafSum {
    public static void main(String[] args) {
        IntNode[] intNodes = BinaryTree.buildIntBinaryTreeV4();
        System.out.println(getMaxRootToLeafSum(intNodes[0]));
    }

    public static int getMaxRootToLeafSum(IntNode root){
        if (root == null) return 0;
        return Math.max(
                getMaxRootToLeafSum(root.getLeft()) + root.getVal(),
                getMaxRootToLeafSum(root.getRight()) + root.getVal()
        );
    }
}

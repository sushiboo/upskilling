package problems.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public static Node[] buildBinaryTree(){
        List<Node> treeNodes = new ArrayList<>();
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);

        return new Node[]{a,b,c,d,e,f};
    }

    public static IntNode[] buildIntBinaryTree(){
        List<IntNode> intNodes = new ArrayList<>();
        IntNode a = new IntNode(3);
        IntNode b = new IntNode(11);
        IntNode c = new IntNode(4);
        IntNode d = new IntNode(4);
        IntNode e = new IntNode(2);
        IntNode f = new IntNode(1);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);

        return new IntNode[]{a,b,c,d,e,f};
    }

    public static IntNode[] buildIntBinaryTreeV2(){
        List<IntNode> intNodes = new ArrayList<>();
        IntNode a = new IntNode(5);
        IntNode b = new IntNode(11);
        IntNode c = new IntNode(3);
        IntNode d = new IntNode(4);
        IntNode e = new IntNode(15);
        IntNode f = new IntNode(12);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);

        return new IntNode[]{a,b,c,d,e,f};
    }

    public static IntNode[] buildIntBinaryTreeV3(){
        List<IntNode> intNodes = new ArrayList<>();
        IntNode a = new IntNode(5);
        IntNode b = new IntNode(11);
        IntNode c = new IntNode(3);
        IntNode d = new IntNode(4);
        IntNode e = new IntNode(2);
        IntNode f = new IntNode(1);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);

        return new IntNode[]{a,b,c,d,e,f};
    }

    public static IntNode[] buildIntBinaryTreeV4(){
        List<IntNode> intNodes = new ArrayList<>();
        IntNode a = new IntNode(3);
        IntNode b = new IntNode(11);
        IntNode c = new IntNode(4);
        IntNode d = new IntNode(4);
        IntNode e = new IntNode(-2);
        IntNode f = new IntNode(1);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);

        return new IntNode[]{a,b,c,d,e,f};
    }
}

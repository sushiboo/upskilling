package problems.binarytree;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Node {
    private char val;
    private Node left = null;
    private Node right = null;

    public Node(char val) {
        this.val = val;
    }
}

package problems.binarytree;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IntNode {
    private int val;
    private IntNode right;
    private IntNode left;

    public IntNode(int val) {
        this.val = val;
    }
}

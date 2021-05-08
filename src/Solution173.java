import java.util.ArrayList;
import java.util.List;

public class Solution173 {
    private int idx;
    private List<Integer> arr;

    public Solution173(TreeNode root) {
        idx = 0;
        arr = new ArrayList<>();
        inorderTraverse(root, arr);
    }

    public int next() {
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return idx < arr.size() - 1;
    }

    private void inorderTraverse(TreeNode root, List<Integer> arr) {
        if(root == null) return;
        inorderTraverse(root.left, arr);
        arr.add(root.val);
        inorderTraverse(root.right, arr);
    }
}

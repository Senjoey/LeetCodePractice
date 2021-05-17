import java.util.Deque;
import java.util.LinkedList;

public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            if(--k == 0) {
                return cur.val;
            }
            root = cur.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        one.right = two;
        int result = new Solution230().kthSmallest(one, 2);
        System.out.println(result);
    }
}

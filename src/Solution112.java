import java.util.LinkedList;
import java.util.Queue;

public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> sumQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode cur = nodeQueue.poll();
            int curSum = sumQueue.poll();
            if(cur.left == null && cur.right == null) {
                if(curSum == targetSum) {
                    return true;
                }
            }
            if(cur.left != null) {
                nodeQueue.offer(cur.left);
                sumQueue.offer(curSum + cur.left.val);
            }
            if(cur.right != null) {
                nodeQueue.offer(cur.right);
                sumQueue.offer(curSum + cur.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        one.left = two;
        System.out.println(new Solution112().hasPathSum(one, 2));
    }
}

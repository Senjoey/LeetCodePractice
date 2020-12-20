/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        oneSideMaxSum(root);
        return res;
    }
    public int oneSideMaxSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = Integer.max(0, oneSideMaxSum(root.left));
        int right = Integer.max(0, oneSideMaxSum(root.right));
        res = Integer.max(res, left+right+root.val);
        return Integer.max(left, right) + root.val;
    }
}
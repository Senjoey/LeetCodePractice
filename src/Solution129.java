public class Solution129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevNum) {
        if(root == null){
            return 0;
        }
        int num = prevNum * 10 + root.val;
        if(root.left == null && root.right == null) {
            return num;
        }
        return dfs(root.left, num) + dfs(root.right, num);
    }
}

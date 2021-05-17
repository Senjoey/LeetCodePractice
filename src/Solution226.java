public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invert(root.left);
        invert(root.right);
    }
}

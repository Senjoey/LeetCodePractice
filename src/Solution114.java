public class Solution114 {

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if(cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {// The key
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}

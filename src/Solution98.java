public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return myIsValidBST(root, null, null);
    }

    public boolean myIsValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) return true;
        if ((minNode != null && root.val <= minNode.val) || (maxNode != null && root.val >= maxNode.val)) return false;
        boolean isLeftIsValidBST = myIsValidBST(root.left, minNode, root);
        boolean isRightIsValidBST = myIsValidBST(root.right, root, maxNode);
        return isLeftIsValidBST && isRightIsValidBST;
    }



    public static void main(String[] args) {

        System.out.println(new Solution98().isValidBST(new TreeNode(Integer.MAX_VALUE)));


    }
}

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int subtract = getDepth(root.left) - getDepth(root.right);
        if(Math.abs(subtract) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two21 = new TreeNode(2);
        TreeNode two22 = new TreeNode(2);
        TreeNode three31 = new TreeNode(3);
        TreeNode three32 = new TreeNode(3);
        TreeNode four41 = new TreeNode(4);
        TreeNode four42 = new TreeNode(4);
        root.left = two21;
        root.right = two22;
        two21.left = three31;
        two21.right = three32;
        three31.left = four41;
        three31.right = four42;
        System.out.println(new Solution110().getDepth(root));
    }
}

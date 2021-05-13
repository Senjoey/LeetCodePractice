public class Solution222 {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int heightLeft = getHeight(root.left);
        int heightRight = getHeight(root.right);
        if(heightLeft == heightRight) {
            int leftAndRootNodesNum = 1 << heightLeft;
            int rightNodeNum = countNodes(root.right);
            return leftAndRootNodesNum + rightNodeNum;
        } else {
            int leftNodeNum = countNodes(root.left);
            int rightAndRootNodeNum = 1 << heightRight;
            return leftNodeNum + rightAndRootNodeNum;
        }
    }

    public int getHeight (TreeNode root) {
        if(root == null) {
            return 0;
        }
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        System.out.println(new Solution222().countNodes(root));
    }
}

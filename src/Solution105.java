import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildMyTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }

    public TreeNode buildMyTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = inMap.get(root.val);
        int leftLength = inRoot - inStart;
        root.left = buildMyTree(preOrder, preStart+1, preStart+leftLength, inOrder, inStart, inRoot-1, inMap);
        root.right = buildMyTree(preOrder, preStart+leftLength+1, preEnd, inOrder, inRoot+1, inEnd, inMap);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode res = new Solution105().buildTree(preorder, inorder);
        System.out.println(res);
    }
}
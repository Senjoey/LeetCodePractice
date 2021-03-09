import java.util.HashMap;

public class Solution106 {
    int[] post;
    HashMap<Integer, Integer> memo = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder;
        for(int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        return buildTree(0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(is > ie || ps > pe) return null;
        int idx = memo.get(post[pe]);
        TreeNode root = new TreeNode(post[pe]);
        root.left = buildTree(is, idx-1, ps, ps+idx-is-1);
        root.right = buildTree(idx+1, ie, ps+idx-is, pe-1);
        return root;
    }
}

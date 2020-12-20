import java.util.ArrayList;
import java.util.List;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        return myTraversal(root, res);
    }

    public List<Integer> myTraversal(TreeNode root, List<Integer> res) {
        if(root == null) return res;
        res = myTraversal(root.left, res);
        res.add(root.val);
        res = myTraversal(root.right, res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        root.right = two;
        TreeNode three = new TreeNode(3);
        two.left = three;
        Solution94 solution94 = new Solution94();
        List<Integer> res = solution94.inorderTraversal(root);
        for(int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }
}

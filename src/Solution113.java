import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> prefixList = new ArrayList<>();
        helper(res, root, targetSum, prefixList);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int targetSum, List<Integer> prefixList) {
        prefixList.add(root.val);
        if(root.left == null && root.right == null) {
            if(root.val == targetSum){
                res.add(new ArrayList<>(prefixList));
            }
            prefixList.remove(prefixList.size()-1);
            return;
        }
        if(root.left != null) {
            helper(res, root.left, targetSum - root.val, prefixList);
        }
        if(root.right != null) {
            helper(res, root.right, targetSum - root.val, prefixList);
        }
        prefixList.remove(prefixList.size()-1);
    }
}

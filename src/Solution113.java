import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> prefixList = new ArrayList<>();
        prefixList.add(root.val);
        helper(res, root, targetSum, prefixList);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int targetSum, List<Integer> prefixList) {
        if(root.left == null && root.right == null) {
            if(root.val == targetSum){
                prefixList.add(root.val);
                res.add(prefixList);
            }
            prefixList.remove(prefixList.size()-1);
            return;
        }
        if(root.left != null) {
            prefixList.add(root.left.val);
            helper(res, root.left, targetSum - root.val, prefixList);
        }
        if(root.right != null) {
            prefixList.add(root.right.val);
            helper(res, root.right, targetSum - root.val, prefixList);
        }
        prefixList.remove(prefixList.size()-1);
    }
}

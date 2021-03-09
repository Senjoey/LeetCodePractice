import java.util.ArrayList;
import java.util.List;

public class Solution99 {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        // Step 1: Get the inorder list of the original tree
        List<TreeNode> nums = new ArrayList<>();
        inorderTraverse(root, nums);
        // Step 2: Find the x and y which is the node that are to be swapped
        List<TreeNode> toBeSwapped = findNodesToBeSwapper(nums);
        // Step 3: Swap x and y
        swap(toBeSwapped.get(0), toBeSwapped.get(1));
    }

    public void inorderTraverse(TreeNode root, List<TreeNode> nums) {
        if(root == null) return;
        inorderTraverse(root.left, nums);
        nums.add(root);
        inorderTraverse(root.right, nums);
    }

    public List<TreeNode> findNodesToBeSwapper(List<TreeNode> nums) {
        TreeNode firstNode=null, secondNode = null;
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i).val > nums.get(i+1).val){
                if(firstNode == null)
                    firstNode = nums.get(i);
                secondNode = nums.get(i+1);
            }
        }
        List<TreeNode> res= new ArrayList<>();
        res.add(firstNode);
        res.add(secondNode);
        return res;
    }

    public void swap(TreeNode firstNode, TreeNode secondNode) {
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
}

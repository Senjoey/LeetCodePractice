import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                TreeNode node;
                if(isReverse) {
                    node = queue.pollLast();
                    if(node.right != null)
                        queue.offerFirst(node.right);
                    if(node.left != null)
                        queue.offerFirst(node.left);
                } else{
                    node = queue.pollFirst();
                    if(node.left != null)
                        queue.add(node.left);
                    if(node.right != null)
                        queue.add(node.right);
                }
                level.add(node.val);
            }
            result.add(level);
            isReverse = !isReverse;
        }
        return result;
    }
}

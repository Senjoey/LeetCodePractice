import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            result.add(level);
        }
        return result;
    }
}

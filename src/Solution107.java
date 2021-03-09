import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(level);
        }
        List<List<Integer>> newResult = new ArrayList<>();
        for(int i = result.size()-1; i >= 0; i--) {
            newResult.add(result.get(i));
        }
        return newResult;
    }
}

import java.util.LinkedList;
import java.util.List;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        if(root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        for(String path : binaryTreePaths(root.left)) {
            res.add(root.val + "->" + path);
        }
        for(String path : binaryTreePaths(root.right)) {
            res.add(root.val + "->" + path );
        }
        return res;
    }
}


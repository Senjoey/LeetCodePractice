import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Tan Qiong
 * @date 2020/10/27
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while (!st.empty()) {
            TreeNode tmp = st.pop();
            res.add(tmp.val);
            if (tmp.right != null) {
                st.push(tmp.right);
            }
            if(tmp.left != null) {
                st.push(tmp.left);
            }
        }
        return res;
    }
}

/**
 * @author Tan Qiong
 * @date 2020/10/19
 */
public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        return handleString(S).equals(handleString(T));
    }

    public String handleString(String str) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if(s != '#') {
                res.append(s);
            } else {
                if(res.length() > 0) {
                    res.deleteCharAt(res.length()-1);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution844().handleString("a#c"));
    }
}

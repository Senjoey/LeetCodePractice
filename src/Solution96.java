/**
 * G(n) represents the number of unique binary search trees which n nodes can produce
 * f(i) represents the number of unique binary search trees produced when n is the root node
 * G(n) = f(1) + f(2) + f(3) + ... + f(n)
 * f(i) = G(i-1)*G(n-i)
 * So G(n) = G(0)*G(n-1) + G(1)*G(n-2) + ... + G(n-2)*G(1) + G(n-1)*G(0)
 */
public class Solution96 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++) {
            for(int j = 1; j < i+1; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = new Solution96().numTrees(3);
        System.out.println(res);
    }
}

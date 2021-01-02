public class Solution486 {
    public boolean PredictTheWinner(int[] nums) {
        // dp[i][j]表示玩家1拿i到j的分数和玩家2之间的分数的最大差值
        // dp[i][j] = max( nums[i]-dp[i+1][j], nums[j]-dp[i][j-1] )
        // 最后结果是dp[0][num.length-1]
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for(int i = nums.length-1;i >= 0; i--) {
            for(int j = i+1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][nums.length-1]>=0;
    }

    public static void main(String[] args) {
        // [1, 5, 2] False
//        System.out.println(new Solution486().PredictTheWinner(new int[]{1, 5, 2}));

        // [1, 5, 233, 7] True
        System.out.println(new Solution486().PredictTheWinner(new int[]{1, 5, 233, 7}));
    }
}
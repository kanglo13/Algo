package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/17 21:08
 */
public class GetMaxLen {
    public int getMaxLen(int[]nums){
        int n = nums.length;
        int[][]dp = new int[n][2];
        dp[0][0] = nums[0] > 0 ? 1 : 0;
        dp[0][1] = nums[0] < 0 ? 1 : 0;
        int result = dp[0][0];
        for (int i = 1;i < n;i++){
            if (nums[i] > 0){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1] > 0 ? dp[i-1][1] + 1 : 0;
            }
            else if (nums[i] < 0){
                dp[i][1] = dp[i-1][0] + 1;
                dp[i][0] = dp[i-1][1] > 0 ? dp[i-1][1] + 1 : 0;
            }
            else {
                dp[i][0] = 0;
                dp[i][1] = 0;
            }
            result = Math.max(result,dp[i][0]);
        }
        return  result;

    }
}

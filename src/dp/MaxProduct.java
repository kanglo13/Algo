package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/17 20:22
 */
public class MaxProduct {
    public int maxProduct(int[]nums){
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[][]dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1;i < n;i++){
            if (nums[i] >= 0){
                dp[i][1] = Math.max(nums[i],dp[i-1][1] * nums[i]);
                dp[i][0] = Math.min(nums[i],dp[i-1][0] * nums[i]);
            }
            else {
                dp[i][1] = Math.max(nums[i],dp[i-1][0] * nums[i]);
                dp[i][0] = Math.min(nums[i],dp[i-1][1] * nums[i]);
            }
        }
        int result = dp[0][0];
        for (int i = 0;i < n;i++)
            result = Math.max(result,dp[i][0]);
        return result;

    }
}

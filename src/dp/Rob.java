package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/14 15:58
 */
public class Rob {
    public int rob(int[]nums){
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[]dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2;i < n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}

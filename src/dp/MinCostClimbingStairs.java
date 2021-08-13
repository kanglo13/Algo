package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/12 21:45
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[]cost){
        int n = cost.length;
        int[]dp = new int[n+1];
        for (int i = 2;i <=n;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
}

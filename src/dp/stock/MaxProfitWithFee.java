package dp.stock;

/**
 * @author kanglo
 * @create 2021-08-2021/8/29 17:12
 */
public class MaxProfitWithFee {
    public int maxProfit(int[]prices,int fee){
        int n = prices.length;
        if (n < 2)
            return 0;
        int[][]dp = new int[n][2];
        for (int i = 0;i < n;i++){
            if (i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}

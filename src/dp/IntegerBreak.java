package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/31 22:17
 */
public class IntegerBreak {
    public int integerBreak(int n){
       int[]dp = new int[n+1];
       dp[1] = 1;
       for (int i = 2;i <= n;i++){
           for (int j = 1;j <= i - 1;j++){
               dp[i] = Math.max(dp[i],Math.max(j * (i - j),j * dp[i-j]));
           }
       }
       return dp[n];
    }
}

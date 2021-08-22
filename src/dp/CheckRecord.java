package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/18 20:57
 */
public class CheckRecord {
    public int checkRecord(int n){
        final int mod = 1000000007;
        int[][][]dp = new int[n+1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1;i <= n;i++){
            //P
            for (int j = 0;j <= 1;j++){
                for (int k = 0;k <= 2;k++){
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % mod;
                }
            }
            // A
            for (int k = 0;k <= 2;k++){
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k]) % mod;
            }
            //L
            for (int j = 0;j <=1;j++){
                for (int k = 1;k <= 2;k++){
                    dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1]) %mod;
                }
            }
        }
        int result = 0;
        for (int j = 0;j <= 1;j++){
            for (int k = 0;k <= 2;k++){
                result = (result + dp[n][j][k]) % mod;
            }
        }
        return result;
    }
}

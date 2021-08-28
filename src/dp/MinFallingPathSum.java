package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/28 22:36
 */
public class MinFallingPathSum {
    public int minFallingPathSum(int[][]matrix){
        int n = matrix.length;
        int[][]dp = new int[n][n];
        dp[0][0] = matrix[0][0];
        for(int i = 1;i < n;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1;i < n;i++){
            for(int j = 0;j < n;j++){
                if (j == 0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j];
                }
                else if (j == n-1){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + matrix[i][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1])) + matrix[i][j];
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0;i < n;i++){
            result = Math.min(result,dp[n-1][i]);
        }
        return result;


    }
}

package dailyCheckin;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2021-08-2021/8/12 19:07
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s){
        int n = s.length();
        char[]chs = s.toCharArray();
        int[][]dp = new int[n][n];
        for (int i = 0;i < n;i++)
            dp[i][i] = 1;
        for (int i = n-1;i >= 0;i--){
            for (int j = i + 1;j < n;j++){
                if (chs[i] == chs[j])
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}

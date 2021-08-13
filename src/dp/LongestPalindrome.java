package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/12 22:50
 */
public class LongestPalindrome {
    public String longestPalindrome(String s){
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        for (int i = 0;i < n;i++)
            dp[i][i] = true;
        int begin = 0,maxLen = 1;
        for (int i = n-1;i >= 0;i--){
            for (int j = i + 1;j < n;j++){
                if (s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;
                else {
                    if (j - i < 3)
                        dp[i][j] = true;
                    else if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] && (j - i + 1) > maxLen){
                    maxLen = j - i + 1;
                    begin =  i;
                }
            }
        }
        return s.substring(begin,begin+ maxLen);

    }
}

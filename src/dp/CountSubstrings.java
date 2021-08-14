package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/14 0:18
 */
public class CountSubstrings {
    public int countSubstrings(String s){
        int n = s.length();
        if (n < 2)
            return n;
        boolean[][]dp = new boolean[n][n];
        int result = 0;
        for (int i = 0;i < n;i++){
            dp[i][i] = true;
            result++;
        }
        for (int i = n - 1;i >= 0;i--){
            for (int j = i + 1;j < n;j++){
                if (s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;
                else {
                    if (j - i < 3){
                        dp[i][j] = true;
                        result++;
                    }
                    else if (s.charAt(i) == s.charAt(j) && dp[i][j]){
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}

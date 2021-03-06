package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/29 16:25
 */
public class NumDecodings {
    public int numDecodings(String s){
        int n = s.length();
        int[]dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2;i <= n;i++){
            int one = Integer.parseInt(s.substring(i-1,i));
            if (one != 0)
                dp[i] += dp[i-1];
            int two = Integer.parseInt(s.substring(i-2,i));
            if (two <= 26)
                dp[i] += dp[i-2];
        }
        return dp[n];
    }
}

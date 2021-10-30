package dp;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2021-09-2021/9/7 23:10
 */
public class MaxEnvelopes {
    int pre = 0;
    public int maxEnvelopes(int[][]envelopes){
        Arrays.sort(envelopes,(o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0]-o2[0]);
        int n = envelopes.length;
        int[]dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1;i < n;i++){
            for (int j = 0;j < i;j++){
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int result = 0;
        for (int val : dp){
            result = Math.max(result,val);
        }
        return result;
    }
}

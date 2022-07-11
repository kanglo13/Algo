package dailyCheckin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2022-07-2022/7/9 19:32
 */
public class LenLongestFibSubseq {
    public int lenLongestFibSubseq(int[]arr){
        int n = arr.length,ans = 0;
        if (n < 3)
            return 0;
        int[][]dp = new int[n][n];
        for (int i = 0;i < n;i++){
            for (int j = i;j < n;j++){
                for (int k = 0;k < i && arr[i] + arr[k] <= arr[j];k++){
                    if (arr[k] + arr[i] == arr[j])
                        dp[i][j] = Math.max(3,Math.max(dp[i][j],dp[k][i]+1));
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
    public int lenLongestFibSbuseq(int[]arr){
        int n = arr.length,ans = 0;
        Map<Integer,Integer>map = new HashMap<>();
        for (int i =0;i < n;i++){
            map.put(arr[i],i);
        }
        if (n < 3)
            return 0;
        int[][]dp = new int[n][n];
        for (int i = 0;i < n;i++){
            for (int j = i;j < n;j++){
                int target = arr[j] - arr[i];
                if (target >= arr[i])
                    continue;
                if (map.containsKey(target)){
                    int k = map.get(target);
                    dp[i][j] = Math.max(3,dp[k][i] + 1);
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }
}

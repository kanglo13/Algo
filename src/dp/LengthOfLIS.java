package dp;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2021-08-2021/8/10 23:06
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[]nums){
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[]dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int result = 0;
        for(int val : dp){
            if(val > result)
                result = val;
        }
        return result;

    }
}

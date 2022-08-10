package binarySearch;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2022-08-2022/8/9 22:35
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[]nums){
        int n = nums.length;
        int[]dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1;i < n;i++){
            for (int j = 0;j < i;j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int val : dp){
            result = Math.max(val,result);
        }
        return result;
    }
}

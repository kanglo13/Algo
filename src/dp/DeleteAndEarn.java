package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/14 17:07
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[]nums){
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        int n = nums.length;
        int max = 0;
        for (int num : nums){
            if (num > max)
                max = num;
        }
        int[]hash = new int[max+1];
        for (int num : nums)
            hash[num]++;
        int[]dp = new int[max+1];
        dp[1] = hash[1] * 1;
        dp[2] = Math.max(dp[1],hash[2] * 2);
        for (int i = 2;i <= max;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + hash[i]*i);
        }
        return dp[max];
    }
}

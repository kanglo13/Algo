package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/15 10:33
 */
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[]nums){
        if (nums == null || nums.length == 0)
            return 0;
        int curMax ,curMin ,max,min;
        curMax = curMin = min = max = nums[0];
        int sum = nums[0];
        for (int i = 1;i < nums.length;i++){
            sum += nums[i];
            curMax = curMax < 0 ? nums[i] : curMax + nums[i];
            curMin = curMin < 0 ? curMin + nums[i] : nums[i];
            max = Math.max(max,curMax);
            min = Math.min(min,curMin);
        }
        return Math.max(max,sum-min);
    }
}

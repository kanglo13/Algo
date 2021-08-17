package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/15 10:27
 */
public class MaxSubarray {
    public int maxSubArray(int[]nums){
        if (nums == null || nums.length == 0)
            return 0;
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1;i < nums.length;i++){
            preSum = preSum < 0 ? nums[i] : nums[i] + preSum;
            maxSum = Math.max(preSum,maxSum);
        }
        return maxSum;
    }
}

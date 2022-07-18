package SlidingWindow;

/**
 * @author kanglo
 * @create 2022-07-2022/7/13 0:13
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target,int[]nums){
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (target > sum)
            return 0;
        sum = 0;
        int n = nums.length;
        int res = n + 1;
        int left = 0, right = 0;
        while (right < n){
            sum += nums[right];
            while (sum >= target){
                if (res > right - left + 1){
                    res = right - left + 1;
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res;
    }
}

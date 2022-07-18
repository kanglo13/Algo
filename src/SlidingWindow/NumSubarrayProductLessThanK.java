package SlidingWindow;

/**
 * @author kanglo
 * @create 2022-07-2022/7/17 22:57
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[]nums,int k){
        int res = 0;
        int product = 1;
        int n = nums.length;
        int left = 0, right = 0;
        while (right < n){
            product *= nums[right];
            while (product >= k && right -left >= 0){
                product /= nums[left];
                left++;
            }
            res += (right-left+1);
            right++;
        }
        return res;
    }
}

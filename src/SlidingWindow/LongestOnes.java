package SlidingWindow;

/**
 * @author kanglo
 * @create 2022-07-2022/7/17 23:19
 */
public class LongestOnes {
    public int longestOnes(int[]nums,int k){
        int res = 0;
        int n = nums.length;
        int left = 0,right = 0;
        int cnt = 0;
        while (right < n){
            if (nums[right] == 0){
                cnt++;
            }
            while (cnt > k){
                if (nums[left] == 0){
                    cnt--;
                }
                left++;
            }
            res = Math.max(res,right -left+1);
            right++;
        }
        return res;
    }
}

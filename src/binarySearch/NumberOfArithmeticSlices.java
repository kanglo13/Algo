package binarySearch;

/**
 * @author kanglo
 * @create 2021-08-2021/8/10 19:29
 */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[]nums){
       int n = nums.length;
       if (n < 3)
           return 0;
       int[]dp = new int[n];
       int result = 0;
       for (int i = 2;i < n;i++){
           if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
               dp[i] = dp[i-1] + 1;
           }
       }
       for (int i = 0;i < n;i++)
           result += dp[i];
       return result;
    }
}

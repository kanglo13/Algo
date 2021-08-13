package dailyCheckin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2021-08-2021/8/11 21:34
 */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[]nums){
        int n = nums.length;
        if (n < 3)
            return 0;
        int result = 0;
        Map<Long,Integer>[]dp = new HashMap[n];
        for (int i = 0;i < n;i++)
            dp[i] = new HashMap<>();
        for (int i = 1;i < n;i++){
            for (int j = 0;j < i;j++){
                long diff = (long) (nums[i] - nums[j]);
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE)
                    continue;
                dp[i].put(diff,dp[i].getOrDefault(diff,0)+dp[j].getOrDefault(diff,0)+1);
                if (dp[j].containsKey(diff))
                    result += dp[j].get(diff);

            }
        }
        return result;

    }
}

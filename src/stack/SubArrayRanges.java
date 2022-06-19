package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kanglo
 * @create 2022-03-2022/3/5 10:49
 */
public class SubArrayRanges {
    public long subArrayRanges(int[]nums){
        long res = 0;
        int n = nums.length;
        for (int i = 0;i < n;i++){
            int min = nums[i];
            int max = nums[i];
            for (int j = i;j < n;j++){
                min = Math.min(min,nums[j]);
                max = Math.max(max,nums[j]);
                res += max - min;
            }
        }
        return res;
    }
    public long subArrayRangesI(int[]nums){
        return 0;
    }
}

package dailyCheckin;

import java.util.*;

/**
 * @author kanglo
 * @create 2022-08-2022/8/4 20:44
 */
public class MinSubsequence {
    public List<Integer>minSubsequence(int[]nums){
        List<Integer>res = new ArrayList<>();
        int sum = 0;
        int temp = 0;
        for (int num : nums){
            sum += num;
        }
        Arrays.sort(nums);
        for (int i = nums.length -1;i >= 0;i--){
            res.add(nums[i]);
            temp += nums[i];
            if (temp* 2 > sum)
                break;
        }
        return res;
    }
}

package codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-02-2022/2/28 22:25
 */
public class ThreeSum {
    public List<List<Integer>>threeSum(int[]nums){
        List<List<Integer>>res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0;i < n;i++){
            if(nums[i] > 0)
                break;
            int l = i + 1;
            int r = n -1;
            int sum = nums[i] + nums[l] + nums[r];
           while (l < r){
               if (sum == 0){
                   res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                   while (l < r && nums[l] == nums[l+1])
                       l++;
                   while (l < r  && nums[r] == nums[r-1])
                       r--;
               }
               else if (sum < 0)
                   l++;
               else
                   r--;
           }
        }
        return res;
    }
}

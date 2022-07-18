package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kanglo
 * @create 2022-07-2022/7/13 0:26
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[]nums,int k){
        Set<Integer>set = new HashSet<>();
        int n = nums.length;
        int left = 0, right = 0;
        int res = n + 1;
        while (right < n){
            set.add(nums[right]);
            int len = right -left + 1;
            while ( set.contains(nums[left])&&set.size() < len){
                if (res > len){
                    res = len;
                }
                set.remove(nums[left]);
                left++;
            }
            right++;
        }
        return res <= k;
    }
}

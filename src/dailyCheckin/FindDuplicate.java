package dailyCheckin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kanglo
 * @create 2022-08-2022/8/21 17:32
 */
public class FindDuplicate {
    public int findDuplicate(int[]nums){
       int n =nums.length;
       int left = 1, right = n-1;
       while (left < right){
           int mid = left + (right - left) / 2;
           int count = 0;
           for (int num : nums){
               if (num <= mid){
                   count++;
               }
           }
           if (count > mid){
               right = mid;
           }
           else {
               left = mid + 1;
           }
       }
        List<Integer>list = new ArrayList<>();
       return left;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer>set2 = new HashSet<>();
        for (int num : nums1)
            set1.add(num);
        for (int num : nums2)
            set2.add(num);
        set1.retainAll(set2);
        int[]res = new int[set1.size()];
        int index = 0;
        for (int num : set1){
            res[index++] = num;
        }
        return res;
    }
}

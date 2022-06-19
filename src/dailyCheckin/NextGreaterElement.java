package dailyCheckin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/3 11:01
 */
public class NextGreaterElement {
    public int nextGreaterElement(int x){
        List<Integer> nums = new ArrayList<>();
        while (x != 0){
            nums.add(x % 10);
            x /= 10;
        }
        int n = nums.size(), index = -1;
        for (int i = 0;i < n -1;i++){
            if (nums.get(i+1) < nums.get(i))
                index = i + 1;
        }
        if (index == -1)
            return -1;
        for (int i = 0;i < index;i++){
            if (nums.get(i) < nums.get(index)){
                swap(nums,i,index);
                break;
            }
        }
        for (int l = 0, r = index-1;l < r;l++,r-- ){
            swap(nums,l,r);
        }
        long ans = 0;
        for (int i = n - 1;i >= 0;i--){
            ans = ans * 10 + nums.get(i);
        }
        return ans > Integer.MAX_VALUE ? -1 : (int)  ans;
    }
    private void swap(List<Integer>nums,int i,int j){
        int temp = nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }
}

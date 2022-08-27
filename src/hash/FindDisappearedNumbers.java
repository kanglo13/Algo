package hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-08-2022/8/21 17:36
 */
public class FindDisappearedNumbers {
    public List<Integer>findDisappearedNumbers(int[]nums){
        int n = nums.length;
        List<Integer>res = new ArrayList<>();
        for (int i = 0;i < n;i++){
            while (nums[i] > 0 && nums[nums[i]-1] != nums[i])
                swap(nums,nums[i]-1,i);
        }
        for (int i = 0;i < n;i++){
            if (nums[i] -1 != i)
                res.add(i+1);
        }
        return res;
    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[]nums = new int[]{4,3,2,7,8,2,3,1};
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        System.out.println(findDisappearedNumbers.findDisappearedNumbers(nums));
    }
}

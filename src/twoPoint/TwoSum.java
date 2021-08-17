package twoPoint;

/**
 * @author kanglo
 * @create 2021-08-2021/8/15 15:08
 */
public class TwoSum {
    public int[]twoSum(int[]nums,int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int sum = nums[left] + nums[right];
            if (sum == target)
                return new int[]{left+1,right+1};
            else if (sum < target)
                left++;
            else
                right--;
        }
        return new int[0];
    }
}

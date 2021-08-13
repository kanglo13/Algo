package binarySearch;

/**
 * @author kanglo
 * @create 2021-08-2021/8/10 21:37
 */
public class SearchII {
    public boolean search(int[]nums,int target){
        int n = nums.length;
        int left = 0, right = n -1;
        while (left < right){
            int mid = left + (right - left+1) / 2;
            if (nums[mid] < nums[right]){
                if (nums[mid] <= target && target <= nums[right])
                    left = mid;
                else
                    right = mid -1;
            }
            else if (nums[mid] > nums[right]){
                if (nums[left] <= target && target <= nums[mid-1])
                    right = mid - 1;
                else
                    left = mid;
            }
            else if (nums[mid] == nums[right]){
                if (target == nums[mid])
                    return true;
                else
                    right--;
            }
        }
        return nums[left] == target;
    }
}

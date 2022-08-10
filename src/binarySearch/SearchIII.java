package binarySearch;

/**
 * @author kanglo
 * @create 2022-08-2022/8/9 22:18
 */
public class SearchIII {
    public boolean search(int[]nums,int target){
        int left = 0, right = nums.length -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]){
                if (nums[left] <= target && target <= nums[mid])
                    right = mid;
                else
                    left = mid + 1;
            }
            else if (nums[left] > nums[mid]){
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid;
            }
            else {
                if (nums[left] == target)
                    return true;
                else
                    left++;
            }
        }
        return nums[left] == target;
    }
}

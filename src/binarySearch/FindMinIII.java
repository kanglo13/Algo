package binarySearch;

/**
 * @author kanglo
 * @create 2022-08-2022/8/9 22:46
 */
public class FindMinIII {
    public int findMin(int[]nums){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] < nums[right])
                right = mid;
            else
                right--;
        }
        return nums[left];
    }
}

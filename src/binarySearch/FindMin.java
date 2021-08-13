package binarySearch;

/**
 * @author kanglo
 * @create 2021-08-2021/8/10 21:58
 */
public class FindMin {
    public int findMin(int[]nums){
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right])
                right = mid;
            else
                left = mid + 1;
        }
        return nums[left];
    }
}

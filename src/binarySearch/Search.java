package binarySearch;

/**
 * @author kanglo
 * @create 2021-08-2021/8/9 23:47
 */
public class Search {
    public int search(int[]nums,int target){
        int n = nums.length;
        if (n == 0)
            return -1;
        int left = 0 ,right = n -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < right){
                if (nums[mid] <= target && target <=nums[right])
                    left = mid;
                else
                    right = mid -1;
            }
            else {
                if (nums[left] <= target && target <= nums[mid])
                    right = mid;
                else
                    left = mid + 1;
            }
        }
        return  -1;
    }
}

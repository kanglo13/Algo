package binarySearch;

/**
 * @author kanglo
 * @create 2022-08-2022/8/21 22:17
 *  [4,5,6,7,0,1,2]
 */
public class RatateArray {
    public int search(int[]nums,int target){
        int left = 0, right = nums.length -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                if (nums[left] <= target && target <= nums[mid])
                    right = mid;
                else
                    left = mid + 1;
            }
            else {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
    public boolean searchII(int[]nums,int target){
        int left = 0 , right = nums.length -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                if (nums[left] <= target && target <= nums[mid])
                    right = mid;
                else
                    left = mid + 1;
            }
            else if (nums[mid] < nums[right]){
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid;
            }
            else {
                if (nums[right] == target)
                    return true;
                else
                    right--;
            }
        }
        return nums[left] == target;
    }
    /*
     [4,5,6,7,0,1,2]
     */
    public int findMin(int[]nums){
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[left];
    }
    public int findMinII(int[]nums){
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid =left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }
            else if(nums[mid] < nums[right]){
                right = mid;
            }
            else {
                right--;
            }
        }
        return nums[left];
    }
}

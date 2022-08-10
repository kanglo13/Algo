package binarySearch;

/**
 * @author kanglo
 * @create 2022-08-2022/8/4 22:22
 */
public class SearchInsert {
    public int searchInsert(int[]nums,int target){
        int left = 0,right = nums.length - 1;
        if (target > nums[right])
            return nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (target > nums[mid])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[]nums = new int[]{1,3,5,6};
        int target = 2;
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(nums,target));
    }
}

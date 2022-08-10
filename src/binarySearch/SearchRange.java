package binarySearch;

/**
 * @author kanglo
 * @create 2022-08-2022/8/4 21:41
 */
public class SearchRange {
    public int[]searchRange(int[]nums,int target){
        if (nums == null || nums.length == 0)
            return new int[]{-1,-1};
        int left = search(nums,0,nums.length-1,target);
        if (nums[left] != target)
            return new int[]{-1,-1};
        int right = search2(nums,0,nums.length-1,target);
        return new int[]{left,right};
    }
    private int search(int[]nums,int left,int right,int target){
        while (left < right){
            int mid = left + (right - left) / 2;
            if (target > nums[mid])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    private int search2(int[]nums,int left,int right,int target){
        while (left < right){
            int mid = left + (right -left+1) / 2;
            if (target < nums[mid]){
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[]nums = new int[]{5,7,7,8,8,10};
        int[]nums1 = new int[]{1};
        int target1 = 1;
        int target = 8;
        SearchRange searchRange = new SearchRange();
        int[]res = searchRange.searchRange(nums,target);
        for (int num : res)
            System.out.println(num);

    }
}

package twoPoint;

/**
 * @author kanglo
 * @create 2021-08-2021/8/15 14:36
 */
public class SortedSquares {
    public int[] sortedSquares(int[]nums){
        int n = nums.length;
        int[]result = new int[n];
        int left = 0, right = n - 1;
        int index = n - 1;
        while (left <= right){
            if (Math.abs(nums[left]) >= Math.abs(nums[right])){
                result[index--] = nums[left] * nums[left];
                left++;
            }
            else {
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}

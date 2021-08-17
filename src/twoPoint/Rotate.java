package twoPoint;

/**
 * @author kanglo
 * @create 2021-08-2021/8/15 14:49
 */
public class Rotate {
    public void rotate(int[]nums,int k){
        int n = nums.length;
        k %= n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private void reverse(int[]nums,int left,int right){
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

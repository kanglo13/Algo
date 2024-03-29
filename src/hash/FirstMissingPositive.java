package hash;

/**
 * @author kanglo
 * @create 2022-08-2022/8/21 17:35
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[]nums){
        int n = nums.length;
        for (int i = 0;i < n;i++){
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] -1] != nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }
        for (int i = 0;i < n;i++){
            if (nums[i] -1 != i)
                return i + 1;
        }
        return n + 1;
    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

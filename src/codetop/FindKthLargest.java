package codetop;

import org.jetbrains.annotations.NotNull;

/**
 * @author kanglo
 * @create 2022-02-2022/2/27 17:39
 */
public class FindKthLargest {
    public int findKthLargest(int[]nums,int k){
        int n = nums.length;
        int l = 0,h = n -1;
        k = n - k;
        while (l <= h){
            int j = partition(nums,l,h);
            if (j == k)
                return nums[j];
            else if (j > k)
                h = j -1;
            else
                l = j + 1;
        }
        return nums[l];

    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int partition(int @NotNull []nums, int l, int h){
        int i = l, j = h + 1;
        int povit = nums[l];
        while (i < j){
            while (i != h && nums[++i] < povit);
            while (j != l && nums[--j] > povit);
            swap(nums,i,j);
        }
        swap(nums,j,l);
        return j;
    }
}

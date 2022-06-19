package codetop;

/**
 * @author kanglo
 * @create 2022-02-2022/2/27 21:10
 */
public class SortArray {
    public int[]sortArray(int[]nums){
        int l = 0 ,h = nums.length-1;
        quickSort(nums,l,h);
        return nums;
    }
    private void quickSort(int[]nums,int l,int h){
        if (l >= h)
            return;
        int j = partition(nums,l,h);
        quickSort(nums,l,j-1);
        quickSort(nums,j+1,h);
    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }
    private int partition(int[]nums,int l,int h){
        int povit = nums[l];
        int i = l,j = h + 1;
        while (true){
            while (i != h && nums[++i] < povit);
            while (j != l && nums[--j] > povit );
            if (i >= j)
                break;
            swap(nums,i,j);
        }
        swap(nums,j,l);
        return j;
    }
}

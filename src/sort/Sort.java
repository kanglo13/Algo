package sort;

/**
 * @author kanglo
 * @create 2022-08-2022/8/23 18:21
 */
public class Sort {
    public static void main(String[] args) {
        int[]nums = new int[]{1,4,2,5,2,0,8,12,0};
        Sort sort = new Sort();
    }
    public void bubbleSort(int[]arr){
        if (arr.length < 2)
            return;
        int n = arr.length;
        for (int i = 0;i < n;i++){
            boolean swapped = false;
            for (int j = 1;j < n - i;j++){
                if (arr[j] > arr[j-1]){
                    swap(arr,j,j-1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }
    public void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void swapXOR(int[]nums,int i,int j){
        if (nums[i] == nums[j])
            return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}

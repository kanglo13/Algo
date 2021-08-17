package twoPoint;

/**
 * @author kanglo
 * @create 2021-08-2021/8/15 15:16
 */
public class MoveZeroes {
    public void moveZeroes(int[]nums){
        int n = nums.length;
        int count = 0;
        int index = 0;
        for (int num : nums)
            if (num != 0)
                count++;
        for (int num : nums ){
            if (num != 0){
                nums[index++] = num;
            }
        }
        for (int i = count;i < n;i++){
            nums[i] = 0;
        }
    }
}

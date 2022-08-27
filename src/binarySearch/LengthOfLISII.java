package binarySearch;

/**
 * @author kanglo
 * @create 2022-08-2022/8/10 22:16
 */
public class LengthOfLISII {
    public int lengthOfLIS(int[]nums){
        int n = nums.length;
        if (n <= 1)
            return n;
        int[]tail = new int[n];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1;i < n;i++){
            if (nums[i] > tail[end]){
                tail[++end] = nums[i];
            }else {
                int left = 0, right = end;
                while (left < right){
                    int mid = left + (right -left) / 2;
                    if (tail[mid]  < nums[i]){
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        end++;
        return end;
    }
}

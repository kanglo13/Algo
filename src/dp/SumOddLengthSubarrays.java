package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/29 11:16
 */
public class SumOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[]arr){
        int n = arr.length;
        int[]preSum = new int[n+1];
        for (int i = 1;i <= n;i++)
            preSum[i] = arr[i-1] + preSum[i-1];
        int result = 0;
        for (int len = 1;len <= n;len += 2){
            for (int i = 0;i+len <= n;i++){
                result += preSum[i+len] - preSum[i];
            }
        }
        return result;
    }
}

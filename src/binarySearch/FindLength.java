package binarySearch;

/**
 * @author kanglo
 * @create 2022-08-2022/8/16 22:32
 */
public class FindLength {
    public int findLength(int[]nums1,int[] nums2){
        int m = nums1.length, n = nums2.length;
        int[][]dp = new int[m+1][n+1];
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                if (nums1[i] == nums2[j]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}

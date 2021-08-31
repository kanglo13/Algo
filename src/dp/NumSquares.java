package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-08-2021/8/31 21:19
 */
public class NumSquares {
    public int numSquares(int n){
        int max = n + 1;
        int[]dp = new int[max];
        Arrays.fill(dp,max);
        dp[0] = 0;
        List<Integer>list = genSquares(n);
        for (int square : list){
            for (int i = square;i <= n;i++){
                dp[i] = Math.min(dp[i],dp[i-square]+1);
            }
        }
        return dp[n];
    }
    private List<Integer>genSquares(int n){
        List<Integer>list = new ArrayList<>();
        int diff = 3;
        int square = 1;

        while (square <= n) {
            list.add(square);
            square += diff;
            diff += 2;
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 101;
        NumSquares numSquares = new NumSquares();
        List<Integer>list = numSquares.genSquares(n);
        for (int num : list)
            System.out.println(num);
    }
}

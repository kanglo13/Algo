package dfs;

import javax.print.DocFlavor;

/**
 * @author kanglo
 * @create 2021-09-2021/9/1 22:24
 */
public class MovingCount {
    private final int[][]direction = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    private int m;
    private int n;
    private int k;
    public int movingCount(int m,int n,int k){
        int[][]matrix = new int[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        dfs(matrix,0,0);
        int result = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (matrix[i][j] == 1)
                    result++;
            }
        }
        return result;
    }
    private void dfs(int[][]matrix,int r,int c){
        if (r < 0 || r >= m  || c < 0 || c >= n || matrix[r][c] == 1 ||bitSum(r)+ bitSum(c) > k)
            return;
        matrix[r][c] = 1;
        for (int[]d : direction){
            dfs(matrix,r+d[0],c+d[1]);
        }
    }
    private int bitSum(int num){
        int sum = 0;
        int rest = 0;
        while (num > 0){
            rest = num % 10;
            sum += rest;
            num /= 10;
        }
        return sum;
    }
}

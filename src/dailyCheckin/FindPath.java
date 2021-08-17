package dailyCheckin;

/**
 * @author kanglo
 * @create 2021-08-2021/8/15 9:54
 */
public class FindPath {
    private final int mod = 1000000007;
    private final int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int findPath(int m,int n,int maxMove,int startRow,int startColumn){
        if (maxMove == 0)
            return 0;
        int[][]dp = new int[m][n];
        for (int k = 0;k < maxMove;k++){
            int[][]temp = new int[m][n];
            for (int i = 0;i < m;i++){
                for (int j = 0;j < n;j++){
                    for (int[]d : direction){
                        if (i+d[0] < 0 || i + d[0] >= m || j + d[1] < 0 || j + d[1] >= n)
                            temp[i][j]++;
                        else
                            temp[i][j] = (temp[i][j] + dp[i+d[0]][j+d[1]]) % mod;
                    }
                }
            }
            dp = temp;
        }
        return dp[startRow][startColumn];
    }
}

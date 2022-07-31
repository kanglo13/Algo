package bfs;

/**
 * @author kanglo
 * @create 2022-07-2022/7/26 22:49
 */
public class LongestIncreasingPath {
    private int m;
    private int n;
    private final int[][]direction = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][]matrix){
        m = matrix.length;
        n = matrix[0].length;
        int[][]memo = new int[m][n];
        int res = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0; j < n; j++) {
                if (memo[i][j] == 0){
                    res = Math.max(res,dfs(matrix,memo,i,j));
                }
            }
        }
        return res;
    }
    public int dfs(int[][]matrix,int[][]memo,int r,int c){
        if (!valid(r,c))
            return 1;
        for (int[]d : direction){
            int row = r + d[0];
            int col = c + d[1];
            if (valid(row,col) && matrix[row][col] > matrix[r][c]){
                memo[r][c] = Math.max(memo[r][c],dfs(matrix,memo,row,col)) + 1;
            }
        }
        return memo[r][c];
    }
    public boolean valid(int r, int c){
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}

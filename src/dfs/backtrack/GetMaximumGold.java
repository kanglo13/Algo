package dfs.backtrack;

/**
 * @author kanglo
 * @create 2022-02-2022/2/7 22:07
 */
public class GetMaximumGold {
    private final int[][]direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    private int m;
    private int n;
    public int getMaximumGold(int[][]grid){
         m = grid.length;
         n = grid[0].length;
         int result = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] > 0){
                    result = Math.max(result,dfs(grid,i,j));
                }
            }
        }
        return result;
    }
    private int dfs(int[][]grid,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return 0;
        int memo = grid[r][c];
        int sum = grid[r][c];
        grid[r][c] = 0;
        int temp = 0;
        for (int[]d : direction){
            temp = Math.max(temp,dfs(grid,r+d[0],c+d[1]));
        }
        sum += temp;
        grid[r][c] = memo;
        return sum;
    }
}

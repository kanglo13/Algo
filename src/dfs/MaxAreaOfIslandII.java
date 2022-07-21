package dfs;

/**
 * @author kanglo
 * @create 2022-07-2022/7/20 22:54
 */
public class MaxAreaOfIslandII {
    private int m;
    private int n;
    private final int[][]direction  = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][]grid){
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i =0;i < m;i++){
            for (int j =0; j < n;j++){
                if (grid[i][j] == 1){
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
        }
        return res;

    }
    private int dfs(int[][]grid,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return 0;
        int sum = 1;
        grid[r][c] = 0;
        for (int[]d : direction){
            sum += dfs(grid,r + d[0],c + d[1]);
        }
        return sum;
    }
}

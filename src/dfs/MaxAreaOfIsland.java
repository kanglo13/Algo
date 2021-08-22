package dfs;

/**
 * @author kanglo
 * @create 2021-08-2021/8/18 21:36
 */
public class MaxAreaOfIsland {
    private final int[][]direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private int m;
    private int n;
    public int maxAreaOfIsland(int[][]grid){
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1){
                    result = Math.max(result,dfs(grid,i,j));
                }
            }
        }
        return result;
    }
    private int dfs(int[][]grid,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return 0;
        int area = 1;
        grid[r][c] = 0;
        for (int[]d : direction){
            area += dfs(grid,r+d[0],c+d[1]);
        }
        return area;
    }
}

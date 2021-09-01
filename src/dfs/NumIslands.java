package dfs;

/**
 * @author kanglo
 * @create 2021-09-2021/9/1 22:04
 */
public class NumIslands {
    private final int[][]direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    private int m;
    private int n;
    public int numIslands(char[][]grid){
        this.m = grid.length;
        this.n = grid[0].length;
        int result = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == '1'){
                    result++;
                    dfs(grid,i,j);
                }
            }
        }
        return result;
    }
    private void dfs(char[][]grid,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        for (int[]d : direction){
            dfs(grid,r+d[0],c+d[1]);
        }
    }
}

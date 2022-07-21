package dfs;

/**
 * @author kanglo
 * @create 2022-07-2022/7/20 21:47
 */
public class IslandPerimeter {
    int m;
    int n;
    private final int[][]direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int islandPerimeter(int[][]grid){
        m = grid.length;
        n = grid[0].length;
        int num = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j <n;j++){
                if (grid[i][j] == 1){
                    num = dfs(grid,i,j);
                }
            }
        }
        return num * 2 + 2;

    }
    private int dfs(int[][]grid,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return 0;
        int num = 1;
        grid[r][c] = 0;
        for (int[]d : direction){
            num += dfs(grid,r+d[0],c+d[1]);
        }
        return num;

    }
}

package dfs;

/**
 * @author kanglo
 * @create 2021-09-2021/9/2 22:19
 */
public class MaxAreaOfIslands {
    private final int[][]direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private int m;
    private int n;
   public int maxAreaOfIsland(int[][]grid){
       m = grid.length;
       n = grid[0].length;
       int result = 0;
       for (int i = 0; i < m;i++){
           for (int j = 0;j < n;j++){
               if (grid[i][j] == 1){
                   result = Math.max(result,dfs(i,j,grid));
               }
           }
       }
       return result;
   }
   private int dfs(int r,int c,int[][]grid){
       if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
           return 0;
       int area = 1;
       grid[r][c] = 0;
       for (int[]d : direction){
           area += dfs(r+d[0],c+d[1],grid);
       }
       return area;
   }
}

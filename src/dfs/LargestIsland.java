package dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author kanglo
 * @create 2022-07-2022/7/20 21:57
 */
public class LargestIsland {
    private int m;
    private int n;
    private final int[][]direction = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int largestIsland(int[][]grid){
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        int index = 2;
        Map<Integer,Integer>map = new HashMap<>();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1){
                    int area = dfs(grid,i,j,index);
                    map.put(index,area);
                    res = Math.max(area,res);
                    index++;
                }
            }
        }
        if (map.size() == 0)
            return 1;
        for (int i = 0;i < m;i++){
            for (int j =0;j < n;j++){
                if (grid[i][j] == 0){
                    Set<Integer> neighbors = getNeighbors(grid,i,j);
                    if (neighbors.size() == 0)
                        continue;
                    int size = 1;
                    for (int neighbor : neighbors){
                        size += map.getOrDefault(neighbor,0);
                    }
                    res = Math.max(res,size);
                }
            }
        }

        return res;
    }
    private int dfs(int[][]grid,int r,int c,int index){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 1)
            return 0;
        grid[r][c] = index;
        int sum = 1;
        for (int[]d : direction){
            sum += dfs(grid,r + d[0],c+d[1],index);
        }
        return sum;
    }
    private Set<Integer> getNeighbors(int[][]grid,int r,int c){
        Set<Integer> set = new HashSet<>();
        for (int[]d : direction){
            int row = r + d[0];
            int col = c + d[1];
            if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0)
                continue;
            set.add(grid[row][col]);
        }
        return set;
    }
}

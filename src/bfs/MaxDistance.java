package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kanglo
 * @create 2022-01-2022/1/20 22:14
 */
public class MaxDistance {
    private final int[][]direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int maxDistance(int[][]grid){
        int n = grid.length;
        Deque<int[]>deque = new ArrayDeque<>();
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1)
                    deque.add(new int[]{i,j});
            }
        }
        int[]point = null;
        boolean hasOcean = false;
        while (!deque.isEmpty()){
            point = deque.poll();
            int r = point[0],c = point[1];
            for (int[]d : direction){
                int nextR = r + d[0];
                int nextC = c + d[1];
                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || grid[nextR][nextC] != 0)
                    continue;
                grid[nextR][nextC] = grid[r][c] + 1;
                hasOcean = true;
                deque.add(new int[]{nextR,nextC});

            }
        }
        if (point == null || !hasOcean){
            return -1;
        }
        return grid[point[0]][point[1]] -1;

    }
}

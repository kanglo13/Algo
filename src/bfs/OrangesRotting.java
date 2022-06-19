package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kanglo
 * @create 2022-01-2022/1/29 23:53
 */
public class OrangesRotting {
    private final int[][]direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int orangesRotting(int[][]grid){
        int m = grid.length, n = grid[0].length;
        Deque<int[]>deque = new ArrayDeque<>();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 2){
                    deque.add(new int[]{i,j});
                }
            }
        }
        int pathLen = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size-- > 0){
                int[]cur = deque.poll();
                int r = cur[0];
                int c = cur[1];
                for (int[]d : direction){
                    int nextR = r + d[0];
                    int nextC = c + d[1];
                    if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || grid[nextR][nextC] != 1)
                        continue;
                    grid[nextR][nextC]++;
                    deque.add(new int[]{nextR,nextC});
                }
            }
            if (!deque.isEmpty())
                pathLen++;
        }
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return pathLen;
    }

}

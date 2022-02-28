package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kanglo
 * @create 2022-01-2022/1/29 23:26
 */
public class HighestPeak {
    private final int[][]direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int[][]highestPeak(int[][]isWater){
        int m = isWater.length, n = isWater[0].length;
        boolean[][]marked = new boolean[m][n];
        Deque<int[]>deque = new ArrayDeque<>();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (isWater[i][j] == 1){
                    deque.add(new int[]{i,j});
                    marked[i][j] = true;
                    isWater[i][j] = 0;
                }
            }
        }
        while (!deque.isEmpty()){
            int[]cur = deque.poll();
            int r = cur[0];
            int c = cur[1];
            for (int[]d : direction){
                int nextR = r + d[0];
                int nextC = c + d[1];
                if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || marked[nextR][nextC])
                    continue;
                isWater[nextR][nextC] = isWater[r][c] + 1;
                marked[nextR][nextC] = true;
                deque.add(new int[]{nextR,nextC});
            }
        }
        return isWater;
    }
}

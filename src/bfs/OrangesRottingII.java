package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kanglo
 * @create 2022-07-2022/7/26 23:18
 */
public class OrangesRottingII {
    private int m;
    private int n;
    private final int[][]direction = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
    public int orangesRotting(int[][]grid){
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        Deque<int[]>deque = new ArrayDeque<>();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 2)
                    deque.addLast(new int[]{i,j});
            }
        }
        while (!deque.isEmpty()){
            int size = deque.size();
            res++;
            while (size-- > 0){
                int[]cur = deque.pollFirst();
                int r = cur[0], c= cur[1];
                for (int[]d : direction){
                    int row = r + d[0], col = c + d[1];
                    if (valid(row,col) && grid[row][col] == 1){
                        grid[row][col] = 2;
                        deque.addLast(new int[]{row,col});
                    }
                }

            }
        }
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return res == 0 ? 0 : res -1;
    }
    private boolean valid(int r,int c){
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}

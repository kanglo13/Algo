package bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kanglo
 * @create 2021-08-2021/8/22 21:57
 */
public class UpdateMatrix {
    private final int[][]direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int[][]updateMatrix(int[][]mat){
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]>queue = new LinkedList<>();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (mat[i][j] == 0)
                    queue.add(new int[]{i,j});
                else
                    mat[i][j] = - 1;
            }
        }
        while (!queue.isEmpty()){
            int[]cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for (int[]d : direction){
                int nextR = r + d[0];
                int nextC = c + d[1];
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && mat[nextR][nextC] == -1){
                    mat[nextR][nextC] = mat[r][c] + 1;
                    queue.add(new int[]{nextR,nextC});
                }
            }
        }
        return mat;

    }
}

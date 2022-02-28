package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kanglo
 * @create 2022-01-2022/1/20 22:53
 */
public class UpdateMatrixII {
    private final int[][]direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int[][]updateMatrix(int[][]mat){
        int m = mat.length, n = mat[0].length;
        Deque<int[]>deque = new ArrayDeque<>();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (mat[i][j] == 0)
                    deque.add(new int[]{i,j});
                else
                    mat[i][j] = -1;
            }
        }
        while (!deque.isEmpty()){
            int[]point = deque.poll();
            int r = point[0];
            int c = point[1];
            for (int[]d : direction){
                int nextR = r + d[0];
                int nextC = c + d[1];
                if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || mat[nextR][nextC] != -1){
                    mat[nextR][nextC] = mat[r][c] = 1;
                    deque.add(new int[]{nextR,nextC});
                }
            }
        }
        return mat;
    }
}

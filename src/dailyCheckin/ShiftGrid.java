package dailyCheckin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/20 21:06
 */
public class ShiftGrid {
    private int m;
    private int n;
    private int k;
    public List<List<Integer>>shiftGrid(int[][]grid,int k){
        m = grid.length;
        n = grid[0].length;
        this.k = k;
        List<List<Integer>>res = new ArrayList<>();
        int[][]temp = new int[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                int val = grid[i][j];
                int[]index = getIndex(i,j);
                temp[index[0]][index[1]] = val;

            }
        }
        for (int i = 0;i < m;i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0;j < n;j++){
                list.add(temp[i][j]);
            }
            res.add(list);
        }
        return res;

    }
    private int[]getIndex(int i,int j){
        int index = ( i * n + j + k) % (m * n);
        int r = index / n;
        int c = index % n;
        return new int[]{r,c};
    }
}

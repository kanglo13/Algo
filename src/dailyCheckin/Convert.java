package dailyCheckin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-03-2022/3/1 22:01
 */
public class Convert {
    private int N = 1000;
    private char[][]grid = new char[N][N];
    private int[]index= new int[N];
    public String convert(String s,int numRows){
        StringBuilder res = new StringBuilder();
        if (numRows == 1)
            return s;
        Arrays.fill(index,0);
        int n = s.length();
        for (int i = 0,j = 0,k = 1;i < n;i++){
            grid[j][index[j]++] = s.charAt(i);
            j += k;
            if (j < 0){
                j += 2;
                k = 1;
            }
            else if (j == numRows){
                j -= 2;
                k = -1;
            }
        }
        for (int i = 0;i < numRows;i++){
            for (int j = 0;j < index[i];j++){
                res.append(grid[i][j]);
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int a : list)
            System.out.println(a);
        System.out.println("1");
    }
}

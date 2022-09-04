package dailyCheckin;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2022-09-2022/9/3 21:43
 */
public class FindLongestChain {
    public int findLongestChain(int[][]pairs){
        Arrays.sort(pairs,(o1, o2) -> o1[1]-o2[1]);
        int res = 1, temp = pairs[0][1];
        for (int i = 1;i < pairs.length;i++){
            if (pairs[i][1] > temp){
                res++;
                temp = pairs[i][1];
            }
        }
        return res;
    }
}

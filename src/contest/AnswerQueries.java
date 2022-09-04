package contest;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author kanglo
 * @create 2022-08-2022/8/28 10:31
 */
public class AnswerQueries {
    public int[] answerQueries(int[]nums,int[]queries){
        int n = nums.length, m = queries.length;
        int[]res = new int[m];
        Arrays.sort(nums);
        for (int i = 0;i < m;i++){
            int cnt = 0;
            int temp = queries[i];
            for (int num : nums){
                if (num <= temp){
                    cnt++;
                    temp-=num;
                }
            }
            res[i] = cnt;
        }
        return res;
    }

    public static void main(String[] args) {
        int[]nums = new int[]{4,5,2,1};
        int[]queries = new int[]{3,10,21};
        AnswerQueries answerQueries = new AnswerQueries();
        for (int val : answerQueries.answerQueries(nums,queries))
            System.out.println(val);
    }
}

package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/17 21:41
 */
public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[]values){
        int n = values.length;
        int max = values[0];
        int result = Integer.MIN_VALUE;
        for (int i = 1;i < n;i++){
            result = Math.max(values[i]-i+max,result);
            max = Math.max(max,values[i]+i);
        }
        return  result;
    }
}

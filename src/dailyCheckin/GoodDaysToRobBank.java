package dailyCheckin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-03-2022/3/6 10:41
 */
public class GoodDaysToRobBank {
    public List<Integer>goodDaysToRobBank(int[]security,int time){
        int n = security.length;
        int[]left = new int[n];
        int[]right = new int[n];
        for (int i =1;i < n;i++){
            if (security[i] <= security[i-1]){
                left[i] = left[i-1] +1;
            }
            if (security[n-i-1] <= security[n-i]){
                right[n-i-1] = right[n-i] + 1;
            }
        }
        List<Integer>ans = new ArrayList<>();
        for (int i = time;i < n-time;i++){
            if (left[i] >= time && right[i] >= time)
                ans.add(i);
        }
        return ans;
    }
}

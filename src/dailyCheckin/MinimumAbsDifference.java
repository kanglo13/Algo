package dailyCheckin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/4 22:17
 */
public class MinimumAbsDifference {
    public List<List<Integer>>minimumAbsDifference(int[]arr){
        List<List<Integer>>result = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return result;
        Arrays.sort(arr);
        int len = arr.length;
        int min = arr[1] - arr[0];
        for (int i = 0;i < len - 1;i ++){
            int cur = arr[i+1] - arr[i];
            if (cur < min){
                result.clear();
                min = cur;
            }
            else {
                result.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return result;
    }
}

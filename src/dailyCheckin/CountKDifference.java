package dailyCheckin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2022-02-2022/2/9 21:23
 */
public class CountKDifference {
    public int countKDifference(int[]nums,int k){
        Map<Integer,Integer>map = new HashMap<>();
        int result = 0;
        for (int num : nums){
            if (map.containsKey(num+k))
                result += map.get(num+k);
            if (map.containsKey(num-k))
                result += map.get(num-k);
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return result;
    }
}

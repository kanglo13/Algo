package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2022-07-2022/7/13 22:59
 */
public class LongestSubstring {
    public int longestSubstring(String s,int k){
        int res = 0;
        int n = s.length();
        Map<Integer,Integer>map = new HashMap<>();
        int left  = 0, right = 0;
        int valid = 0;
        while (right < n){
            int ch = s.charAt(right) - 'a';
            map.put(ch,map.getOrDefault(ch,0)+1);
            if (map.get(ch) >= k)
                valid++;
            while (valid == map.size()){
                res = Math.max(res,right-left+1);
                int ch1 = s.charAt(left) - 'a';
                map.put(ch1,map.getOrDefault(ch1,0)-1);
                if (map.get(ch1) < k)
                    valid--;
                if (map.get(ch1) == 0)
                    map.remove(ch1);
                left++;
            }
            right++;

        }
        return res;
    }
}

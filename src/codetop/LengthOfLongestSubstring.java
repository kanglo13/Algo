package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2022-02-2022/2/27 17:15
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s){
        int n = s.length();
        int[]last = new int[128];
        for (int i = 0;i < 128;i++){
            last[i] = -1;
        }
        int res = 0;
        int start = 0;
        for (int i = 0;i < n;i++){
            int index = s.charAt(i);
            start = Math.max(start,last[index]+1);
            res = Math.max(res,i-start+1);
            last[index] = i;
        }
        return  res;
    }
    private int lengthOfLongestSubstringII(String s){
        int n = s.length();
        int res = 0, start = 0;
        Map<Character,Integer>map = new HashMap<>();
        for (int i= 0;i < n;i++){
            if (map.containsKey(s.charAt(i))){
                start = Math.max(start,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            res = Math.max(res,i-start+1);
        }
        return res;
    }
}

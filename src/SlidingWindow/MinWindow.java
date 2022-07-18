package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author kanglo
 * @create 2022-07-2022/7/12 23:10
 */
public class MinWindow {
    public String mindow(String s,String t){
        int m = s.length(), n = t.length();
        if (n > m)
            return "";
        int[]cnt = new int[128];
        for (int i = 0;i < n;i++){
            int ch = t.charAt(i);
            cnt[ch]++;
        }
        int left = 0, right = 0;
        int num = 0, res = Integer.MAX_VALUE;
        String ans = "";
        while (right < m){
            int ch1 = s.charAt(right);
            cnt[ch1]--;
            if (cnt[ch1] >= 0){
                num++;
            }
            while (num == n){
                if (res > right -left + 1){
                    res = right - left + 1;
                    ans = s.substring(left,right+1);
                }
                int ch2 = s.charAt(left);
                cnt[ch2]++;
                if (cnt[ch2] >= 1){
                    num--;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
    public String minWindow(String s,String t){
        int m = s.length(), n = t.length();
        if (n > m)
            return "";
        Map<Character,Integer>need = new HashMap<>();
        Map<Character,Integer>window = new HashMap<>();
        for (char ch : t.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        int left = 0, right = 0;
        int num = 0;
        int res = Integer.MAX_VALUE;
        String ans = "";
       while (right < m){
            char ch1 = s.charAt(right);
            if (need.containsKey(ch1)){
                window.put(ch1,window.getOrDefault(ch1,0)+1);
                if (Objects.equals(window.get(ch1), need.get(ch1)))
                    num++;
            }
            while (num == need.size()){
                if (res > right - left + 1){
                    res = right - left + 1;
                    ans = s.substring(left,right+1);
                }
                char ch2 = s.charAt(left);
                if (need.containsKey(ch2)){
                    if (Objects.equals(window.get(ch2), need.get(ch2)))
                        num--;
                    window.put(ch2,window.getOrDefault(ch2,0)-1);

                }
                left++;
            }
            right++;

       }
        return ans;
    }
}

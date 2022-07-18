package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/17 22:00
 */
public class FindAnagram {
    public List<Integer>findAnagrams(String s,String p){
        int m = s.length(), n = p.length();
        List<Integer>res = new ArrayList<>();
        if (n > m)
            return res;
        int[]cnt = new int[26];
        for (int i = 0;i  < n;i++){
            cnt[p.charAt(i)-'a']++;
        }
        int left = 0, right = 0;
        while (right < m){
            int ch = s.charAt(right) - 'a';
            cnt[ch]--;
            while (cnt[ch] < 0){
                int ch1 = s.charAt(left) - 'a';
                cnt[ch1]++;
                left++;
            }
            if (right - left + 1 == n){
                res.add(left);
            }
            right++;
        }
        return res;
    }
}

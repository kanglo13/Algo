package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-08-2021/8/18 22:59
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s,String p){
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        int[]needs = new int[26];
        int[]window = new int[26];
        int need = 0, valid = 0;
        int left = 0, right = 0;
        for (char ch : p.toCharArray())
            needs[ch-'a']++;
        for (int val : needs)
            if (val > 0)
                need++;
        while (right < s.length()){
            int ch1 = s.charAt(right) - 'a';
            window[ch1]++;
            if (needs[ch1] > 0 && window[ch1] == needs[ch1])
                valid++;
            while (right - left + 1 == p.length()){
                if (valid == need)
                    result.add(left);
                int ch2 = s.charAt(left) - 'a';
                if (needs[ch2] > 0 && window[ch2] == needs[ch2])
                    valid--;
                window[ch2]--;
                left++;
            }
            right++;
        }
        return result;
    }
}

package SlidingWindow.interview;

/**
 * @author kanglo
 * @create 2022-07-2022/7/11 22:40
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int res = 0, left = 0, right = 0;
        int[]cnt = new int[26];
        while (right < n){
            int ch = s.charAt(right) - 'a';
            while (cnt[ch] > 1){
                int ch1 = s.charAt(left) - 'a';
                cnt[ch1]--;
                left++;
            }
            res = Math.max(right-left+1,res);
            right++;
        }
        return 0;
    }
}

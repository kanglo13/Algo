package SlidingWindow;

/**
 * @author kanglo
 * @create 2021-08-2021/8/17 23:08
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int left = 0, right = 0;
        int result = 0;
        int[]window = new int[128];
        while (right < n){
            char ch1 = s.charAt(right);
            window[ch1]++;
            right++;
            while (window[ch1] > 1){
                char ch2 = s.charAt(left);
                window[ch2]--;
                left++;
            }
            result = Math.max(result,right-left);
        }
        return result;
    }
}

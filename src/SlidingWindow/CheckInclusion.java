package SlidingWindow;

/**
 * @author kanglo
 * @create 2021-08-2021/8/17 23:17
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1,String s2){
        if (s1 == null || s1.length() == 0)
            return true;
       int m = s1.length(), n = s2.length();
       int count = 0, valid = 0;
       int[]needs = new int[26];
       int[]window = new int[26];
       for (char ch : s1.toCharArray()){
           needs[ch-'a']++;
       }
       for (int val : needs)
           if (val > 0)
               count++;
       int left = 0, right = 0;
       while (right < n){
           int ch1 = s2.charAt(right) - 'a';
           window[ch1]++;
           if (needs[ch1] > 0 && needs[ch1] == window[ch1])
               valid++;
           while (right - left + 1 == m){
               if (valid == count)
                   return true;
               int ch2 = s2.charAt(left) - 'a';
               if (needs[ch2] > 0 && needs[ch2] == window[ch2])
                   valid--;
               window[ch2]--;
               left++;
           }
           right++;
       }
        return false;
    }
}

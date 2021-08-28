package dailyCheckin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kanglo
 * @create 2021-08-2021/8/19 20:57
 */
public class ReverseVowels {
    public String reverseVowels(String s){
        char[]key = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch : key)
            set.add(ch);
        int left = 0, right = s.length()-1;

        while (left < right){
            while (!set.contains(chars[left]) && left < s.length()-1)
                left++;
            while (!set.contains(chars[right]) && right > 0)
                right--;
            if (left >= right)
                break;
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;

        }
        return new String(chars);

    }
}

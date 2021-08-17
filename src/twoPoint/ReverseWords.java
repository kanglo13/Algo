package twoPoint;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2021-08-2021/8/15 15:54
 */
public class ReverseWords {
    public String reverseWords(String s){
        char[] chars = s.toCharArray();
        int n = chars.length;
        int index = 0;
        for (int i = 0;i < n;i++){
            if (chars[i] == ' '){
                reverse(chars,index,i-1);
                index = i + 1;
                continue;
            }
            if (i == n - 1)
                reverse(chars,index,i);
        }
        return new String(chars);
    }
    private void reverse(char[]chars,int left ,int right){
        while (left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}

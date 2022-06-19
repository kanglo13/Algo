package contest;

/**
 * @author kanglo
 * @create 2021-10-2021/10/24 10:32
 */
public class CountValidWords {
    public int countValidWords(String sentence){
        String[]strs = sentence.split(" ");
        int result = 0;
        for (String str : strs){
            if (isSentence(str) && !str.equals(" "))
                result++;
        }
        return result;
    }
    private boolean isSentence(String s){
        s = s.trim();
        int count = 0;
        if (s.length() == 0)
            return false;
        for (int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if (Character.isDigit(ch))
                return false;
            if (ch == '-'){
                if (i == 0)
                    return false;
                if (i == s.length()-1)
                    return false;
                char left = s.charAt(i-1);
                char right = s.charAt(i+1);
                if (left < 'a' || left > 'z' || right < 'a' || right > 'z')
                    return false;
                count++;

            }
            if (ch == ',' || ch == '.' || ch == '!'){
                if (i != s.length() -1)
                    return false;
            }
        }
        return count <= 1;

    }
}

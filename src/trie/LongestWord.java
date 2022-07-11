package trie;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2022-07-2022/7/9 17:35
 */
public class LongestWord {
    public String longestWord(String[]words){
        Arrays.sort(words,(o1, o2) -> o2.length() - o1.length() == 0 ? o1.compareTo(o2) : o2.length() - o1.length());
        return words[0];
    }
}

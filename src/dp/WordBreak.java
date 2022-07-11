package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kanglo
 * @create 2022-07-2022/7/10 11:18
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String>wordDict){
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        for (int i = 1;i <= n;i++){
            for (String word :wordDict){
                int len = word.length();
                if (i-len >= 0 && s.substring(i-len,i).equals(word)){
                    dp[i] |= dp[i-len];
                }
            }
        }
        return dp[n];
    }
    public boolean wordBreakII(String s,List<String>wordDict){
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[]dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1;i <= n;i++){
            for (int j = 0;j < i;j++){
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}

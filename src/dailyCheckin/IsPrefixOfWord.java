package dailyCheckin;

/**
 * @author kanglo
 * @create 2022-08-2022/8/21 15:53
 */
public class IsPrefixOfWord {
    public int isPrefixOfWord(String sentence,String searchWord){
        String[]strs = sentence.split(" ");
        for (int i = 0;i < strs.length;i++){
            if (strs[i].startsWith(searchWord))
                return i;
        }
        return -1;
    }
}

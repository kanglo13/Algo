package dailyCheckin;

/**
 * @author kanglo
 * @create 2021-08-2021/8/17 0:08
 */
public class CheckRecord {
    public boolean checkRecord(String s){
        int n = s.length();
        int countA = 0, countL = 0;
        char[]chars = s.toCharArray();
        for (int i = 0;i < n;i++){
            if(chars[i] == 'L')
                countL++;
            else {
                countL = 0;
                if (chars[i] == 'A')
                    countA++;
            }
            if (countA >= 2)
                return false;
            if (countL >= 3)
                return false;
        }
        return true;
    }
}

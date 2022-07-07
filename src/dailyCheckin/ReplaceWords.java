package dailyCheckin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/7 20:52
 */
public class ReplaceWords {
    public String replaceWords(List<String>dictionary,String sentence){
        dictionary.sort((o1, o2) -> o1.length() - o2.length());
        String[]strings = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < strings.length;i++){
            String temp = strings[i];
            for (String word : dictionary){
                if (temp.contains(word) && temp.indexOf(word) == 0){
                    temp = word;
                    break;
                }
            }
            stringBuilder.append(temp);
            if (i != strings.length -1){
                stringBuilder.append(" ");
            }

        }
        return stringBuilder.toString();

    }
}

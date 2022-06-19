package dailyCheckin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kanglo
 * @create 2022-01-2022/1/30 0:14
 */
public class UncommonFromSentences {
    public String[]uncommonFromSentences(String s1,String s2){
        String[]strs1 = s1.split(" ");
        String[]strs2 = s2.split(" ");
        Map<String,Integer>map1 = new HashMap<>();
        Map<String,Integer>map2 = new HashMap<>();
        List<String>result = new ArrayList<>();
        for (String str : strs1){
            map1.put(str,map1.getOrDefault(str,0)+1);
        }
        for (String str : strs2){
            map2.put(str,map2.getOrDefault(str,0)+1);
        }
        for (String key : map1.keySet()){
            if (map1.get(key) == 1){
                if (!map2.containsKey(key))
                    result.add(key);
            }
        }
        for (String key : map2.keySet()){
            if (map2.get(key) == 1){
                if (!map1.containsKey(key))
                    result.add(key);
            }
        }
        return result.toArray(new String[0]);
    }
}

package dailyCheckin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kanglo
 * @create 2021-10-2021/10/8 21:42
 */
public class FindRepeatedDnaSequences {
    public List<String>findRepeatedDnaSequences(String s){
        List<String>result = new ArrayList<>();
        Map<String,Integer>map = new HashMap<>();
        int n = s.length();
        for (int i =  0;i < n - 10;i++){
            String dna = s.substring(i,i+10);
            if (map.containsKey(dna)){
                if (map.get(dna) > 1){
                    result.add(dna);
                }
            }
            map.put(s.substring(i,i+10),map.getOrDefault(s.substring(i,i+10),0)+1);
        }
        for (String key : map.keySet()){
            if (map.get(key) > 1)
        }
        return result;
    }
}

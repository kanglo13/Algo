package unionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2022-07-2022/7/19 22:18
 */
public class TrulyMostPopular {
    public String[]trulyMostPopular(String[]names,String[]synonyms){
        Map<String,Integer>map = new HashMap<>();
        Map<String,String>uf = new HashMap<>();
        for (String name : names){
            int index1 = name.indexOf("(");
            int index2 = name.indexOf(")");
            String word = name.substring(0,index1);
            int freq = Integer.parseInt(name.substring(index1+1,index2));
            map.put(word,freq);
        }
        for (String pair : synonyms){
            int index = pair.indexOf(",");
            String name1 = pair.substring(1,index);
            String name2 = pair.substring(index+1,pair.length()-1);
            while (uf.containsKey(name1)){
                name1 = uf.get(name1);
            }
            while (uf.containsKey(name2)){
                name2 = uf.get(name2);
            }
            if (!name1.equals(name2)){
                int freq = map.getOrDefault(name1,0) + map.getOrDefault(name2,0);
                String trulyName = name1.compareTo(name2) < 0 ? name1 : name2;
                String nickName = name1.compareTo(name2) < 0 ? name2 : name1;
                uf.put(nickName,trulyName);
                map.remove(nickName);
                map.put(trulyName,freq);
            }
        }
        String[]res = new String[map.size()];
        int index = 0;
        for (String name : map.keySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append("(");
            sb.append(map.get(name));
            sb.append(")");
            res[index++] = sb.toString();
        }
        return res;
    }
}

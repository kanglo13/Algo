package topK;

import java.util.*;

/**
 * @author kanglo
 * @create 2021-09-2021/9/21 22:19
 */
public class TopKFrequentWords {
    public List<String>topKFrequent(String[]words,int k){
        List<String>result = new ArrayList<>();
        Map<String,Integer>map = new HashMap<>();
        PriorityQueue<String>queue = new PriorityQueue<>((o1, o2) -> map.get(o1) == map.get(o2) ? o1.compareTo(o2) : map.get(o2)-map.get(o1));
        for (String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        queue.addAll(map.keySet());
        while (k-- > 0){
            result.add(queue.poll());
        }
        return result;
    }
}

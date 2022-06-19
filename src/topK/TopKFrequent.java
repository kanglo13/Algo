package topK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author kanglo
 * @create 2021-09-2021/9/21 22:12
 */
public class TopKFrequent {
    public int[]topKFrequent(int[]nums,int k){
        int[]result = new int[k];
        Map<Integer,Integer>map = new HashMap<>();
        PriorityQueue<Integer>queue = new PriorityQueue<>((o1, o2) -> map.get(o2)-map.get(o1));
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        queue.addAll(map.keySet());
        while (k-- > 0){
            result[k] = queue.poll();
        }
        return result;

    }
}

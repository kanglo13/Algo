package bfs;

import java.util.*;

/**
 * @author kanglo
 * @create 2022-02-2022/2/10 20:34
 */
public class OpenLock {
    String t,s;
    Set<String>set = new HashSet<>();
    public int openLock(String[]deadends,String target){
        s = "0000";
        t = target;
        if (s.equals(t))
            return 0;
        if (set.contains(s))
            return -1;
        return bfs();
    }
    private int bfs(){
        Deque<String>deque1 = new ArrayDeque<>(),deque2 = new ArrayDeque<>();
        Map<String,Integer> map1 = new HashMap<>(),map2 = new HashMap<>();
        deque1.add(s);
        map1.put(s,0);
        deque2.add(t);
        map2.put(t,0);
        while (!deque1.isEmpty() && !deque2.isEmpty()){
            int t = -1;
            if (deque1.size() <= deque2.size()){
                t = update(deque1,map1,map2);
            }
            else {
                t = update(deque2,map2,map1);
            }
            if (t != -1)
                return t;
        }
        return -1;
    }
    private int update(Deque<String>deque,Map<String,Integer>cur,Map<String,Integer>other){
        String poll = deque.poll();
        char[]pcs = poll.toCharArray();
        int step = cur.get(poll);
        for (int i = 0;i < 4;i ++){
            for (int j = -1;j <= 1;j++){
                if (j == 0)
                    continue;
                int origin = pcs[i] - '0';
                int next = (origin + j) % 10;
                if (next == -1)
                    next = 9;
                char[]clone = pcs.clone();
                clone[i] = (char) (next+'0');
                String str = String.valueOf(clone);
                if (set.contains(str))
                    continue;
                if (cur.containsKey(str))
                    continue;
                if (other.containsKey(str)){
                    return step + 1 + other.get(str);
                }
                else {
                    deque.add(str);
                    cur.put(str,step+1);
                }
            }
        }
        return -1;
    }
}

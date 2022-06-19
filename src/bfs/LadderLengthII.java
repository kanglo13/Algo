package bfs;

import java.util.*;

/**
 * @author kanglo
 * @create 2022-02-2022/2/9 22:28
 */
public class LadderLengthII {
    private String beginWord,endWord;
    private final Set<String>set = new HashSet<>();
    public int ladderLength(String begainWord, String endWord, List<String>wordList){
        this.beginWord = begainWord;
        this.endWord = endWord;
        set.addAll(wordList);
        if (!set.contains(endWord))
            return 0;

        int result = bfs();
        return result == -1 ? 0 : result + 1;
    }
    private int bfs(){
        Deque<String>deque1 = new ArrayDeque<>(),deque2 = new ArrayDeque<>();
        Map<String,Integer>map1 = new HashMap<>(),map2 = new HashMap<>();
        deque1.add(beginWord);
        deque2.add(endWord);
        map1.put(beginWord,0);
        map2.put(endWord,0);
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
        int n = poll.length();
        for (int i = 0;i < n;i++){
            for (int j = 0;j < 26;j++){
                String sub = poll.substring(0,i) + String.valueOf((char) (j+'a')) + poll.substring(i+1);
                if (set.contains(sub)){
                    if (cur.containsKey(sub))
                        continue;
                    if (other.containsKey(sub)){
                        return cur.get(poll) + 1 + other.get(sub);
                    }
                    else {
                        deque.add(sub);
                        cur.put(sub,cur.get(poll)+1);
                    }
                }
            }
        }
        return -1;
    }
}

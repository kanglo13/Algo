package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/21 20:48
 */
public class LadderLengthI {
    public int ladderLength(String beginWord, String endWord, List<String>wordList){
        int n = wordList.size();
        int begin = 0, end = 0;
        int pathLen = 0;
        for (;end < n;end++){
            if (endWord.equals(wordList.get(end)))
                break;
        }
        if (end == n)
            return 0;
        wordList.add(beginWord);
        n += 1;
        begin = n -1;
        List<Integer>[]graph = buildGraph(wordList);
        Deque<Integer>deque = new ArrayDeque<>();
        boolean[]marked = new boolean[n];
        deque.addLast(begin);
        while (!deque.isEmpty()){
            int size = deque.size();
            pathLen++;
            while (size -- > 0){
                int cur = deque.pollFirst();
                if (cur == end)
                    return pathLen;
                if (marked[cur])
                    continue;
                marked[cur] = true;
                for (int next : graph[cur]){
                    deque.addLast(next);
                }
            }
        }
        return 0;
    }
    private List<Integer>[] buildGraph(List<String>wordList){
        int n = wordList.size();
        List<Integer>[] graph = new List[n];
        for (int i = 0;i < n;i++){
            graph[i] = new ArrayList<>();
            String word1 = wordList.get(i);
            for (int j = 0;j < n;j++){
                String word2 = wordList.get(j);
                if (isConnected(word1,word2)){
                    graph[i].add(j);
                }
            }
        }
        return graph;
    }
    private boolean isConnected(String word1,String  word2){
        int n = word1.length();
        int cnt = 0;
        for (int i = 0;i < n;i++){
            if (word1.charAt(i) != word2.charAt(i)){
                cnt++;
            }
        }
        return cnt == 1;
    }
}

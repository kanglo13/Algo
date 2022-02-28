package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-01-2022/1/20 21:23
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String>wordList){
        if (!wordList.contains(endWord))
            return 0;
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N -1;
        int end = 0;
        while (end < N && !wordList.get(end).equals(endWord)){
            end++;
        }
        if (end == N)
            return 0;
        List<Integer>[]graph = buildGraph(wordList);
        return shortestPath(graph,start,end);
    }
    private int shortestPath(List<Integer>[]graph,int start,int end){
        Deque<Integer>queue = new ArrayDeque<>();
        boolean[]marked = new boolean[graph.length];
        queue.add(start);
        int path = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            path++;
            while (size-- > 0){
                int cur = queue.poll();
                for (int next : graph[cur]){
                    if (end == next){
                        return path;
                    }
                    if (marked[next])
                        continue;
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
    private boolean isConnected(String word1,String word2){
        if (word1.length() != word2.length())
            return false;
        int n = word1.length();
        int diff = 0;
        for (int i = 0;i < n;i++){
            if (word1.charAt(i) != word2.charAt(i))
                diff++;
        }
        return diff == 1;
    }
    private List<Integer>[] buildGraph (List<String>wordList){
        int n = wordList.size();
        List<Integer>[]graph = new List[n];
        for (int i = 0;i < n;i++){
            graph[i] = new ArrayList<>();
            for (int j = 0;j <n;j++){
                if (isConnected(wordList.get(i),wordList.get(j)))
                    graph[i].add(j);
            }
        }
        return graph;
    }
}

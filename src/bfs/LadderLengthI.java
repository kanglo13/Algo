package bfs;

import java.util.*;

/**
 * @author kanglo
 * @create 2022-07-2022/7/21 20:48
 */
public class LadderLengthI {
    public int ladderLength(String beginWord, String endWord, List<String>wordList){
        int end = wordList.indexOf(endWord);
        if (end == -1)
            return 0;
        wordList.add(beginWord);
        int n = wordList.size();
        int start = n - 1;
        Deque<Integer>deque1 = new ArrayDeque<>();
        Deque<Integer>deque2 = new ArrayDeque<>();
        Set<Integer>visited1 = new HashSet<>();
        Set<Integer>visited2 = new HashSet<>();
        int count = 0;
        deque1.addLast(start);
        deque2.addLast(end);
        visited1.add(start);
        visited2.add(end);
        while (!deque1.isEmpty() && !deque2.isEmpty()){
            count++;
            if (deque1.size() > deque2.size()){
                Deque<Integer> temp = deque1;
                deque1 = deque2;
                deque2 = temp;
                Set<Integer> tempSet = visited1;
                visited1 = visited2;
                visited2 = tempSet;
            }
            int size = deque1.size();
            while (size-- > 0){
                String cur = wordList.get(deque1.pollFirst());
                for (int i = 0;i < n;i++){
                    String next = wordList.get(i);
                    if (visited1.contains(i))
                        continue;
                    if (!isConnected(cur,next))
                        continue;
                    if (visited2.contains(i))
                        return count + 1;
                    deque1.addLast(i);
                    visited1.add(i);
                }
            }
        }
        return 0;
    }
    private boolean isConnected(String s1,String s2){
        int diff = 0;
        for (int i = 0;i < s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
            if (diff > 1)
                return false;
        }
        return diff == 1;
    }

}

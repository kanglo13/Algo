package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-02-2022/2/27 21:26
 */
public class NumWays {
    public int numWays(int n,int[][]relation,int k){
        List<Integer>[]graph = new List[n];
        for (int i = 0;i < n;i++)
            graph[i] = new ArrayList<Integer>();
        for (int[]rela : relation){
            graph[rela[0]].add(rela[1]);
        }
        Deque<Integer>deque = new ArrayDeque<>();
        deque.add(0);
        while (!deque.isEmpty() && k-- > 0){
            int size = deque.size();
            while (size-- > 0){
                int poll = deque.poll();
                for (int next : graph[poll])
                    deque.add(next);
            }
        }
        int ans = 0;
        while (!deque.isEmpty()){
            if (deque.pollFirst() == n-1)
                ans++;
        }
        return ans;
    }
}

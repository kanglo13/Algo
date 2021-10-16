package unionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-09-2021/9/21 11:18
 */
public class MinimumEffortPath {
    class UF{
        private int count;
        private int[]size;
        private int[]parent;
        public UF(int n){
            count = n;
            size = new int[n];
            parent = new int[n];
            for (int i = 0;i < n;i++){
                size[i] = 1;
                parent[i] = i;
            }
        }
        public int find(int x){
            while (x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            if (size[rootP] > size[rootQ]){
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
        public boolean connected(int p,int q){
            return find(p) == find(q);
        }
        public int getCount(){
            return count;
        }
    }
    public int minimumEffortPath(int[][]heights){
        int m = heights.length;
        int n = heights[0].length;
        List<int[]>edges = new ArrayList<>();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (j+1 < n){
                    edges.add(new int[]{Math.abs(heights[i][j+1] - heights[i][j]),i*n+j,i*n+j+1});
                }
                if (i+1 < m){
                    edges.add(new int[]{Math.abs(heights[i+1][j]-heights[i][j]),i*n+j,(i+1)*n+j});
                }
            }
        }
        Collections.sort(edges,(o1, o2) -> o1[0]-o2[0]);
        UF uf = new UF(m*n);
        for (int[] edge : edges){
            uf.union(edge[1],edge[2]);
            if (uf.connected(0,m*n-1))
                return edge[0];
        }
        return -1;
    }
}

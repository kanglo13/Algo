package unionFind;

import java.security.PublicKey;

/**
 * @author kanglo
 * @create 2021-09-2021/9/20 11:16
 */
public class UF {
    private int count;
    private int[]size;
    private int[]parent;

    public UF(int n){
        count = n;
        size = new int[n];
        parent = new int[n];
        for (int i = 0;i < n;i++){
            size[i] =1;
            parent[i] = i;
        }
    }
    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        if (size[rootP] > rootQ){
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
    public int find(int x){
        while (x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public int count(){
        return count;
    }
}

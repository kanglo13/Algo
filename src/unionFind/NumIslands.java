package unionFind;

/**
 * @author kanglo
 * @create 2022-07-2022/7/18 23:17
 */
public class NumIslands {
    class UF{
        int count;
        int[]size;
        int[]parent;
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
    }
    public int numIslands(char[][]board){
        int res = 0;

        return res;
    }
}

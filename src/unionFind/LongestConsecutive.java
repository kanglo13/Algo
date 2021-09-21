package unionFind;

/**
 * @author kanglo
 * @create 2021-09-2021/9/20 19:23
 */
public class LongestConsecutive {
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
            if (rootP > rootQ){
                parent[q] = rootP;
                size[rootP] += size[rootQ];
            }
            else {
                parent[p] = rootQ;
                size[rootQ] += rootP;
            }
            count--;
        }
        public boolean connectted(int p,int q){
            return find(p) == find(q);
        }
    }
    public int longestConsecutive(int[]nums){
        int n = nums.length;
        UF uf = new UF(n);
        for (int num : nums){
            uf.union(num,num+1);
        }
        int max = 1;
        for (int num :nums){
            max = Math.max(max,uf.find(num)-num+1);
        }
        return max;
    }
}

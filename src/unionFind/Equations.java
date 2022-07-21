package unionFind;

/**
 * @author kanglo
 * @create 2022-07-2022/7/19 22:36
 */
public class Equations {
    public boolean equationsPossible(String[]equations){
        UF uf = new UF(26);
        for (String equation : equations){
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '='){
                uf.union(a,b);
            }
        }
        for (String equation : equations){
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '!'){
                if (uf.connected(a,b))
                    return false;
            }
        }
        return true;
    }
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
            }else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
        }
        public boolean connected(int p,int q){
            return find(p) == find(q);
        }
    }
}

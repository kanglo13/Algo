package unionFind;

/**
 * @author kanglo
 * @create 2021-09-2021/9/21 11:47
 */
public class ValidateBinaryTreeNodes {
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
        }
        public boolean connected(int p,int q){
            return find(p) == find(q);
        }
        public int getCount(){
            return count;
        }
    }
    public boolean validateBinaryTreeNodes(int n,int[]leftChild,int[]rightChild){
        UF uf = new UF(n);
        for (int i = 0;i < n;i++){
            if (leftChild[i] != -1)
                uf.union(i,leftChild[i]);
            if (rightChild[i] != -1)
                uf.union(i,rightChild[i]);
        }
        return uf.getCount() == 1;
    }
}

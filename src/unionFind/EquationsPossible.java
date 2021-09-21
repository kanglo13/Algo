package unionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-09-2021/9/21 10:51
 */
public class EquationsPossible {
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
    }
    public boolean equationsPossible(String[]equations){
        UF uf = new UF(26);
        List<int[]>list = new ArrayList<>();
        for (String equation : equations){
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '='){
                uf.union(a,b);
            }
            else if (equation.charAt(1) == '!'){
                if (a == b)
                    return false;
                if (uf.connected(a,b))
                    return false;
                list.add(new int[]{a,b});
            }
        }
        if (list.size() > 0){
            for (int[]arr : list){
                if (uf.connected(arr[0],arr[1]))
                    return false;
            }
        }
        return true;
    }
}

package unionFind;

import java.util.*;

/**
 * @author kanglo
 * @create 2021-09-2021/9/20 21:53
 */
public class AccountsMerge {
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
    }
    public List<List<String>>accountsMerge(List<List<String>>accounts){
        List<List<String>>result = new ArrayList<>();
        if (accounts.size() == 0)
            return result;
        int n = accounts.size();
        UF uf = new UF(n);
        Map<String,Integer>mails2id = new HashMap<>();
        for (int i = 0;i < n;i++){
            for (int j = 1;j <accounts.get(i).size();j++){
                if (!mails2id.containsKey(accounts.get(i).get(j))){
                    mails2id.put(accounts.get(i).get(j),i);
                }
                else {
                    uf.union(i,mails2id.get(accounts.get(i).get(j)));
                }
            }
        }
        Map<Integer,List<String>>id2mails = new HashMap<>();
        for (Map.Entry<String,Integer>entry : mails2id.entrySet()){
            int id = uf.find(entry.getValue());
            List<String>emails = id2mails.getOrDefault(id,new ArrayList<>());
            emails.add(entry.getKey());
            id2mails.put(id,emails);
        }
        for (Map.Entry<Integer,List<String>> entry : id2mails.entrySet()){
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String>temp = new ArrayList<>();
            temp.add(accounts.get(entry.getKey()).get(0));
            temp.addAll(emails);
            result.add(temp);
        }
        return result;
        
    }
}

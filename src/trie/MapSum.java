package trie;

/**
 * @author kanglo
 * @create 2022-07-2022/7/8 23:55
 */
public class MapSum {
    class TrieNode{
        int val;
        TrieNode[]children = new TrieNode[26];
    }
    private TrieNode root;
    public MapSum(){
        root = new TrieNode();
    }
    public void insert(String word,int val){
        TrieNode cur = root;
        for (int i = 0;i < word.length();i++){
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null)
                cur.children[index] = new TrieNode();
            cur = cur.children[index];
        }
        cur.val = val;
    }
    public int sum(String prefix){
        TrieNode cur = root;
        for (int i = 0;i < prefix.length();i++){
            int index = prefix.charAt(i) - 'a';
            cur = cur.children[index];
            if (cur == null)
                return 0;
        }
        return dfs(cur );
    }
    private int dfs(TrieNode node){
        if (node == null)
            return 0;
        int sum = 0;
        if (node.val > 0)
            sum = node.val;
        for (TrieNode child : node.children){
            sum += dfs(child);
        }
        return sum;
    }
}

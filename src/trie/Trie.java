package trie;

/**
 * @author kanglo
 * @create 2022-07-2022/7/7 22:08
 */
public class Trie {
    class TrieNode{
        boolean end;
        TrieNode[]children = new TrieNode[26];
    }
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode p = root;
        for (int i = 0;i < word.length();i++){
            int u = word.charAt(i) - 'a';
            if (p.children[u] == null)
                p.children[u] = new TrieNode();
            p = p.children[u];
        }
        p.end = true;
    }
    public boolean serarch(String word){
        TrieNode p = root;
        for (int i = 0;i < word.length();i++){
            int u = word.charAt(i) - 'a';
            if (p.children[u] == null)
                return false;
            p = p.children[u];
        }
        return p.end;
    }
    public boolean startWith(String prefix){
        TrieNode p = root;
        for (int i = 0;i < prefix.length();i++){
            int u = prefix.charAt(i) - 'a';
            if (p.children[u] == null)
                return false;
            p = p.children[u];
        }
        return true;
    }
}

package trie;

/**
 * @author kanglo
 * @create 2022-07-2022/7/7 23:21
 */
public class WordDictionary {
    class TrieNode{
        boolean end;
        TrieNode[]children = new TrieNode[26];
    }
    TrieNode root;
    public WordDictionary(){
        root = new TrieNode();
    }
    public void addWord(String word){
        TrieNode cur = root;
        for (int i = 0;i < word.length();i++){
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null)
                cur.children[index] = new TrieNode();
            cur = cur.children[index];
        }
        cur.end = true;
    }
    public boolean dfs(String word,TrieNode cur,int index){
        int n = word.length();
        if (n == index)
            return cur.end;
        char ch = word.charAt(index);
        if (ch == '.'){
            for (int i = 0;i < 26;i++){
                if (cur.children[i] != null && dfs(word,cur.children[i],index+1 ))
                    return true;
            }
            return false;
        }
        else {
            int u = ch - 'a';
            if (cur.children[u] == null)
                return false;
            return dfs(word,cur.children[u],index+1 );
        }
    }
    public boolean search(String word){
        return dfs(word,root,0);
    }
}

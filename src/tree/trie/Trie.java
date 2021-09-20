package tree.trie;

/**
 * @author kanglo
 * @create 2021-09-2021/9/20 9:34
 */
public class Trie {
    Trie[]next = new Trie[26];
    boolean isEnd = false;
    public Trie(){

    }
    public void insert(String word){
        Trie cur = this;
        for (char ch : word.toCharArray()){
            if (cur.next[ch-'a'] == null){
                cur.next[ch-'a'] = new Trie();
            }
            cur = cur.next[ch-'a'];
        }
        cur.isEnd = true;
    }
    public boolean search(String word){
        Trie cur = this;
        for (char ch : word.toCharArray()){
            if (cur.next[ch-'a'] == null)
                return false;
            cur = cur.next[ch-'a'];
        }
        return cur.isEnd;
    }
    public boolean isStartWith(String prefix){
        Trie cur = this;
        for (char ch : prefix.toCharArray()){
            if (cur.next[ch-'a'] == null)
                return false;
        }
        return false;
    }
}

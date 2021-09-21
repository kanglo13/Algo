package tree.trie;

/**
 * @author kanglo
 * @create 2021-09-2021/9/20 15:05
 */
public class WordDictionary {
    WordDictionary[]next;
    boolean isWord;
    public WordDictionary(){
        next = new WordDictionary[26];
        isWord = false;
    }
    public void addWord(String word){
        WordDictionary cur = this;
        for (char ch : word.toCharArray()){
            if (cur.next[ch-'a'] == null){
                cur.next[ch-'a'] = new WordDictionary();
            }
            cur = cur.next[ch-'a'];
        }
        cur.isWord = true;
    }
    public boolean search(String word){
        WordDictionary cur = this;
        return dfs(word,0,cur);
    }
    private boolean dfs(String word,int index,WordDictionary cur){
        if (index >= word.length())
            return cur.isWord;
        char ch = word.charAt(index);
        if (ch != '.'){
            if (cur.next[ch-'a'] != null)
                return dfs(word,index+1,cur.next[ch-'a']);
            return false;
        }
        for (WordDictionary next : cur.next){
            if (next != null && dfs(word,index+1,next))
                return true;
        }
        return false;
    }
}

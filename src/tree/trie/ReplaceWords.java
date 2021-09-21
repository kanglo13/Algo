package tree.trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kanglo
 * @create 2021-09-2021/9/20 16:05
 */
public class ReplaceWords {
    class Trie{
        Trie[]next = new Trie[26];
        String root = "";
        public void insert(String word){
            Trie cur = this;
            for (char ch : word.toCharArray()){
                if (cur.next[ch-'a'] == null)
                    cur.next[ch-'a'] = new Trie();
                cur = cur.next[ch-'a'];
            }
            cur.root = word;
        }
        public boolean search(String word){
            Trie cur = this;
            for (char ch : word.toCharArray()){
                if (cur.next[ch-'a'] == null)
                    return false;
                cur = cur.next[ch-'a'];
            }
            return cur.root.equals(word);
        }

        public boolean startWith(String prefix){
            Trie cur = this;
            for (char ch : prefix.toCharArray()){
                if (cur.next[ch-'a'] == null)
                    return false;
            }
            return true;
        }
    }
    public String replaceWords(List<String>dictionary,String sentence){
        Trie trie = new Trie();
        for (String word : dictionary)
            trie.insert(word);
        String[]words = sentence.split(" ");
        for (String word : words){

        }
      return "";
    }
}

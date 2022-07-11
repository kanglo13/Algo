package trie;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kanglo
 * @create 2022-07-2022/7/7 22:46
 */
public class ReplaceWords {
    class TrieNode{
        boolean end;
        TrieNode[] children = new TrieNode[26];
    }
    TrieNode root = new TrieNode();
    private void insert(String word){
        TrieNode cur = root;
        for (int i = 0;i < word.length();i++){
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null)
                cur.children[index] = new TrieNode();
            cur = cur.children[index];
        }
        cur.end = true;
    }
    private String query(String word){
        TrieNode cur = root;
        for (int i = 0;i < word.length();i++){
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null)
                break;
            if (cur.children[index].end)
                return word.substring(0,i+1);
            cur = cur.children[index];
        }
        return word;
    }
    public String replaceWords(List<String>dictionary,String sentence){
        dictionary.forEach(this::insert);
        List<String> result = Arrays.stream(sentence.split(" ")).map(this::query).collect(Collectors.toList());
        return String.join(" ",result);
    }
}

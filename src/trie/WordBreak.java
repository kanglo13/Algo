package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/10 15:20
 */
public class WordBreak {
    class Node {
        boolean end;
        String word;
        Node[]children = new Node[26];
    }
    Node root = new Node();
    List<String>res = new ArrayList<>();
    List<String>list = new ArrayList<>();
    private void insert(String word){
        Node cur = root;
        for (int i =0;i < word.length();i++){
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null)
                cur.children[index] = new Node();
            cur = cur.children[index];
        }
        cur.end = true;
        cur.word = word;
    }
    private void dfs(String s,int pos){
        if (pos == s.length()){
            res.add(String.join(" ",list));
            return;
        }
        Node cur = root;
        for (int i = pos;i < s.length();i++){
            int index = s.charAt(i) - 'a';
            if (cur.children[index] == null)
                return;
            if (cur.end){
                list.add(cur.word);
                dfs(s,pos+1);
                list.remove(list.size() -1);
            }
            cur = cur.children[index];
        }
    }
    public List<String>wordBreak(String s,List<String>wordDict){
        List<String>res = new ArrayList<>();
        wordDict.forEach(this::insert);
        dfs(s,0);
        return res;
    }
}

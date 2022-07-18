package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/14 22:36
 */
public class WordFilter {
    class Node{
        Node[]children = new Node[26];
        List<Integer>ids = new ArrayList<>();
    }
    Node preRoot = new Node();
    Node suffRoot = new Node();
    public WordFilter(String[]words){
        for (int i = 0;i < words.length;i++){
            insert(preRoot,words[i],i,false);
            insert(suffRoot,words[i],i,true);
        }
    }
    private int f(String pref,String suff){

        return search(pref,suff);
    }
    private void insert(Node node,String word,int idx,boolean reversed){
        int n = word.length();
        node.ids.add(idx);
        for (int i = reversed ? n -1 : 0;i >= 0 && i < n;i += reversed ? -1 : 1){
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null)
                node.children[index] = new Node();
            node = node.children[index];
            node.ids.add(idx);
        }
    }
    private int search(String pref,String suff){
        Node pre = preRoot;
        Node suf = suffRoot;
        for (int i = 0;i < pref.length();i++){
            int index = pref.charAt(i) - 'a';
            if (pre.children[index] == null)
                return -1;
            pre = pre.children[index];
        }
        for (int i = suff.length()-1;i >= 0;i--){
            int index = suff.charAt(i) - 'a';
            if (suf.children[index] == null)
                return -1;
            suf = suf.children[index];
        }
        List<Integer>preList = pre.ids;
        List<Integer>sufList = suf.ids;
        int m = preList.size(), n = sufList.size();
        for (int i = m-1, j = n-1;i >= 0 && j >= 0;){
            if (preList.get(i) > sufList.get(j))
                i--;
            else if (preList.get(i) < sufList.get(j))
                j--;
            else
                return preList.get(i);
        }
        return -1;
    }
}

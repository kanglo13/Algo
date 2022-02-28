package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2022-02-2022/2/16 22:37
 */
public class LRUCache {
    class DLinkNode{
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode(){};
        public DLinkNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer,DLinkNode>cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head,tail;
    public LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key){
        DLinkNode node = cache.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.value;
    }
    public void put(int key,int value){
        DLinkNode node = cache.get(key);
        if (node == null){
            DLinkNode newNode = new DLinkNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            size++;
            if (size > capacity){
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);

        }

    }
    private void addToHead(DLinkNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(DLinkNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void moveToHead(DLinkNode node){
        removeNode(node);
        addToHead(node);
    }
    private DLinkNode removeTail(){
        DLinkNode res = tail.prev;
        removeNode(res);
        return  res;
    }

}

package code.explorecard.trie;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/map-sum-pairs/solution/
public class MapSumPairs {

    class TrieNode{
        boolean isEnd;
        int sum;
        Map<Character, TrieNode> map;
        TrieNode(){
            sum = 0;
            isEnd = false;
            map = new HashMap<>();
        }
    }

    public static void main(String args[]){

        MapSumPairs obj = new MapSumPairs();

        obj.insert("apple",3);
        System.out.println(obj.sum("app"));
        obj.insert("app",2);
        System.out.println(obj.sum("app"));
        obj.insert("app",2);
        System.out.println(obj.sum("app"));
    }
    TrieNode root;

    public MapSumPairs() {
        root = new TrieNode();
    }

    public void insert(String word,int num) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            if(!curr.map.containsKey(c)){
                curr.map.put(c,new TrieNode());
            }
            curr.sum += num;
            curr = curr.map.get(c);
        }
        curr.sum+=num;
        curr.isEnd = true;
    }

    public int sum(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            if(!curr.map.containsKey(c)){
                return 0;
            }
            curr = curr.map.get(c);
        }
        return curr.sum;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            if(!curr.map.containsKey(c)){
                return false;
            }
            curr = curr.map.get(c);
        }
        return curr.isEnd == true;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c:prefix.toCharArray()){
            if(!curr.map.containsKey(c)){
                return false;
            }
            curr = curr.map.get(c);
        }

        return true;
    }
}

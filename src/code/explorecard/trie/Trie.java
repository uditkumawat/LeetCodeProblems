package code.explorecard.trie;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/implement-trie-prefix-tree/solution/
public class Trie {

    public static void main(String args[]){

        Trie obj = new Trie();

        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));

        System.out.println(obj.startsWith("app"));
        obj.insert("app");

        System.out.println(obj.search("app"));
    }
    class TrieNode{
        boolean isEnd;
        Map<Character,TrieNode> map;
        TrieNode(){
            isEnd = false;
            map = new HashMap<>();
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            if(!curr.map.containsKey(c)){
                curr.map.put(c,new TrieNode());
            }
            curr = curr.map.get(c);
        }
        curr.isEnd = true;
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

package code.blind75;

import java.util.HashMap;
import java.util.Map;

//TC - O(m)
//sc-O(1)
public class ImplementTrie {

    class TrieNode{
        Map<Character,TrieNode> children;
        boolean isEndOfWord;
        TrieNode(){
            children = new HashMap();
            isEndOfWord = false;
        }
    }
    TrieNode root;
    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if(word==null || word.length()==0){
            return;
        }

        TrieNode node = root;
        for(char c:word.toCharArray()){
            if(!node.children.containsKey(c)){
                node.children.put(c,new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {

        if(word==null || word.length()==0){
            return false;
        }

        TrieNode node = root;
        for(char c:word.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEndOfWord==true;
    }

    public boolean startsWith(String word) {

        if(word==null || word.length()==0){
            return false;
        }

        TrieNode node = root;
        for(char c:word.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}

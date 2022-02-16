package code.design;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class WordDictionary {

    class TrieNode
    {
        Map<Character,TrieNode> children;
        boolean isEndOfWord;
        TrieNode(){
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    //TC - O(M) - Length of word, atleast we traverse the whole string
    //SC - O(M) - If it is totally new word and it adds new nodes to Trie
    public void addWord(String word) {

        TrieNode temp = root;
        for(char c:word.toCharArray()){
            if(!temp.children.containsKey(c)){
                temp.children.put(c,new TrieNode());
            }
            temp = temp.children.get(c);
        }
        temp.isEndOfWord = true;
    }

    public boolean searchInNode(String word,TrieNode root) {
        TrieNode temp = root;

        for(int i=0;i<word.length();i++){

            char c = word.charAt(i);

            if(!temp.children.containsKey(c)){

                if(c=='.'){

                    for(char x:temp.children.keySet()){

                        TrieNode child = temp.children.get(x);

                        if(searchInNode(word.substring(i+1),child)){
                            return true;
                        }
                    }
                }
                return false;
            }
            else{
                temp = temp.children.get(c);
            }
        }
        return temp!=null && temp.isEndOfWord;
    }

    public boolean search(String word){
        return searchInNode(word,root);
    }
}

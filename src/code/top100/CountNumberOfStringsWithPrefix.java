package code.top100;

import java.util.HashMap;
import java.util.Map;

//TC - O(number of string)
//SC- O(number of string)
//https://www.youtube.com/watch?v=UsWDLWuBUls
public class CountNumberOfStringsWithPrefix {

    public static void main(String args[]){
        Trie trieObj = new Trie();
        trieObj.insert("abaa");
        trieObj.insert("abac");
        trieObj.insert("abab");
        trieObj.insert("aabc");
        trieObj.insert("aabb");

        TrieNode node = trieObj.search("aba");
        System.out.println(node.countOfPrefixes);
    }

    static class TrieNode
    {
        char c;
        int countOfPrefixes;
        Map<Character,TrieNode> map;
        TrieNode(char c){
            this.c = c;
            this.countOfPrefixes = 1;
            map = new HashMap<>();
        }
    }

    static class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode('\0');
        }

        void insert(String word){
            TrieNode current = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(current.map.containsKey(c)){
                    current = current.map.get(c);
                    current.countOfPrefixes++;
                }
                else{
                    TrieNode newNode = new TrieNode(c);
                    current.map.put(c,newNode);
                    current = current.map.get(c);
                }
            }
            System.out.println("Word inserted-> "+word);
        }

        TrieNode search(String word){
            TrieNode current = root;
            TrieNode finalNode = null;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(current.map.containsKey(c)){
                    current = current.map.get(c);
                    finalNode = current;
                }
            }
            return finalNode;
        }
    }
}

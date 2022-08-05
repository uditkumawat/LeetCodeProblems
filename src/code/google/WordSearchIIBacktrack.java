package code.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Optimized using backtrack in trie
//https://leetcode.com/problems/word-search-ii/discuss/59881/My-Java-solution-using-Trie
//https://www.youtube.com/watch?v=EmvsBM7o-5k
public class WordSearchIIBacktrack {

    public static void main(String args[]){

        char board[][] = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};

        List<String> dict = new ArrayList<>();
        dict.add("oath");
        dict.add("pea");
        dict.add("eat");
        dict.add("rain");

        WordSearchII obj = new WordSearchII();

        List<String> words = obj.wordSearch(board,dict);

        for(String word:words){
            System.out.println(word);
        }
    }

    class TrieNode{
        Map<Character,TrieNode> children;
        boolean isWord;
        TrieNode(){
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }

    TrieNode root = new TrieNode();

    public void insertToTrie(String word){

        TrieNode node = root;
        for(char c:word.toCharArray()){
            if(!node.children.containsKey(c)){
                node.children.put(c,new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public List<String> wordSearch(char board[][],List<String> dict){

        List<String> res = new ArrayList<>();

        //insert each word into trie
        for(String word:dict){
            insertToTrie(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                char c = board[row][col];
                if(root.children.containsKey(c)){
                    searchUtil(board,row,col,rows,cols,"",res,root);
                }
            }
        }

        return res;
    }

    public void searchUtil(char board[][],int row,int col,int rows,int cols,String word,List<String> res,TrieNode node){

        if(row<0 || row>=rows || col<0 || col>=cols || board[row][col]=='$'){
            return;
        }

        char c = board[row][col];

        if(!node.children.containsKey(c)){
            return;
        }

        node = node.children.get(c);

        String newWord = word+c;
        if(node.isWord){
            res.add(newWord);
        }

        board[row][col] = '$';

        searchUtil(board,row-1,col,rows,cols,newWord,res,node);
        searchUtil(board,row,col-1,rows,cols,newWord,res,node);
        searchUtil(board,row+1,col,rows,cols,newWord,res,node);
        searchUtil(board,row,col+1,rows,cols,newWord,res,node);

        board[row][col] = c;
    }
}

package code.top100;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {


    public static void main(String args[]){

        char board[][] = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String words[] = {"oath","pea","eat","rain"};

        TrieClass obj = new TrieClass();
        List<String> res = obj.findWords(board,words);

        for(String str:res){
            System.out.print(str+" ");
        }
    }

    static class TrieClass {
        class TrieNode {
            public char c;
            public boolean isEnd;
            public TrieNode children[];
            public String word;

            TrieNode(char c) {
                this.c = c;
                this.isEnd = false;
                this.children = new TrieNode[26];
                this.word = null;
            }
        }

        TrieNode root = new TrieNode('\0');

        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode(c);
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
            curr.word = word;
        }

        public boolean search(String word) {
            TrieNode node = getNode(word);
            return node != null && node.isEnd == true && node.word.equals(word);
        }

        public TrieNode getNode(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    return null;
                }
                curr = curr.children[c - 'a'];
            }

            return curr;
        }


        public List<String> findWords(char[][] board, String[] words) {
            if (words == null || words.length == 0) {
                return new ArrayList<>();
            }

            List<String> res = new ArrayList<>();

            //store words in trie
            for (String word : words) {
                insert(word);
            }

            int rows = board.length;
            int cols = board[0].length;

            //backtrack at each cell
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    backtrack(board, row, col, rows, cols, res, root);
                }
            }

            return res;
        }

        public void backtrack(char board[][], int row, int col, int rows, int cols, List<String> res, TrieNode root) {

            char c = board[row][col];
            TrieNode currNode = root.children[c - 'a'];

            if(c=='#' || currNode==null){
                return;
            }

            if (currNode.word != null) {
                res.add(currNode.word);
                currNode.word = null;
            }

            board[row][col] = '#';

            int dirs[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

            for (int i = 0; i < dirs.length; i++) {
                int newRow = row + dirs[i][0];
                int newCol = col + dirs[i][1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || board[newRow][newCol]=='#') {
                    continue;
                }

                char newC = board[newRow][newCol];

                if (currNode.children[newC - 'a'] != null) {
                    backtrack(board, newRow, newCol, rows, cols, res, currNode);
                }
            }

            board[row][col] = c;
        }
    }
}

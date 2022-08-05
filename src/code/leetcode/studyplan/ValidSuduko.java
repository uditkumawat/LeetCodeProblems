package code.leetcode.studyplan;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
//TC - O(n*n)
//SC - O(n)
public class ValidSuduko {

    public boolean isValidSudoku(char[][] board) {

        int n = 9;

        Set<Character> rows[] = new HashSet[n];
        Set<Character> cols[] = new HashSet[n];
        Set<Character> boxes[] = new HashSet[n];

        for(int i=0;i<n;i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                char c = board[i][j];
                if(c!='.'){
                    int boxIndex = 3*(i/3)+(j/3);
                    if(isAlreadyPresent(rows[i],cols[j],boxes[boxIndex],c)){
                        return false;
                    }
                    rows[i].add(c);
                    cols[j].add(c);
                    boxes[boxIndex].add(c);
                }
            }
        }

        return true;

    }

    public boolean isAlreadyPresent(Set<Character> row,Set<Character> cols,Set<Character> box,char c){
        if(row.contains(c) || cols.contains(c) || box.contains(c)){
            return true;
        }
        return false;
    }

    public boolean isDigit(char c){
        if((c-'0')>=0 && (c-'0')<=9){
            return true;
        }
        return false;
    }
}

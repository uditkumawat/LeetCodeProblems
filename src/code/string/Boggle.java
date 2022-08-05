package code.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boggle {

    Set<String> dict;
    char grid[][];
    boolean visited[][];
    int rows;
    int cols;
    Boggle(char grid[][], Set<String> dictionary){
        this.grid = grid;
        this.rows = this.grid.length;
        this.cols = this.grid[0].length;
        this.visited = new boolean[this.rows][this.cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                this.visited[i][j] = false;
            }
        }
        this.dict = dictionary;
    }

    public static void main(String args[]){
        char[][] grid = new char[][] {
                {'c', 'a', 't'},
                {'r', 'r', 'e'},
                {'t', 'o', 'n'}
        };

        String[] dict = {"cat", "cater", "cartoon", "art", "toon", "moon", "eat", "ton"};
        HashSet<String> dictionary = new HashSet<String>();
        for (String s: dict) {
            dictionary.add(s);
        }

        Boggle obj = new Boggle(grid,dictionary);
        List<String> res = obj.findAllWords();

        for(String s:res){
            System.out.println(s);
        }
    }

    public List<String> findAllWords(){
        List<String> res = new ArrayList<String>();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                find(i,j,sb,res);
            }
        }
        return res;
    }

    private void find(int row, int col, StringBuilder sb,List<String> res){
        if(row<0 || row>=rows || col<0 || col>=cols || visited[row][col]){
            return;
        }

        if(dict.contains(sb.toString())){
            res.add(sb.toString());
            return;
        }

        visited[row][col] = true;
        sb.append(grid[row][col]);

        find(row+1,col,sb,res);
        find(row,col+1,sb,res);
        find(row-1,col,sb,res);
        find(row,col-1,sb,res);

        find(row+1,col+1,sb,res);
        find(row+1,col-1,sb,res);
        find(row-1,col+1,sb,res);
        find(row-1,col-1,sb,res);

        sb.deleteCharAt(sb.length()-1);
        visited[row][col] = false;

    }

}

package code.march.challenge;

//https://leetcode.com/problems/champagne-tower/
//https://www.youtube.com/watch?v=PbdeSn67Kfs
public class ChampagneTower {

    public static void main(String args[]){

        int poured = 100000009, query_row = 33, query_glass = 17;

        ChampagneTower obj = new ChampagneTower();

        System.out.println(obj.champagneTower(poured,query_row,query_glass));

    }
    public double champagneTower(int poured, int query_row, int query_glass) {

        double A[][] = new double[102][102];

        A[0][0] = (double)poured;

        for(int r=0;r<=query_row;r++){
            for(int c=0;c<=r;c++){
                double remain = (A[r][c]-1.0)/2.0;
                if(remain>0){
                    A[r+1][c]+=remain;
                    A[r+1][c+1]+=remain;
                }
            }
        }

        return Math.min(1,A[query_row][query_glass]);
    }


    double champagneTowerNew(int poured, int query_row, int query_glass) {
        double result[][] = new double[101][101];
        result[0][0] = poured;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                if (result[i][j] >= 1) {
                    result[i + 1][j] += (result[i][j] - 1) / 2.0;
                    result[i + 1][j + 1] += (result[i][j] - 1) / 2.0;
                    result[i][j] = 1;
                }
            }
        }
        return result[query_row][query_glass];
    }
}

package code.top100;

/**
 * Time complexity: \mathcal{O}(N \times M)O(N×M).
 *
 * Space complexity: \mathcal{O}(N \times M)O(N×M).
 */
public class UniquePaths {

    public static void main(String args[]){
        int n=3;
        int m=3;

        System.out.println(numberOfPaths(n,m));
    }

    public static int numberOfPaths(int n,int m){

        int cost[][] = new int[n][m];

        for(int i=0;i<n;i++){
            cost[i][0] = 1;
        }

        for(int i=0;i<m;i++){
            cost[0][i] = 1;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                cost[i][j] = cost[i-1][j]+cost[i][j-1];
            }
        }

        return cost[n-1][m-1];
    }
}

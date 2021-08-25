package code.leetcode.doordash;

//62. Unique Paths
public class UniquePaths {

    public static void main(String args[]){

        int arr[][] = new int[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==0 || j==0)
                    arr[i][j]=1;
                else{
                    arr[i][j]=0;
                }
            }
        }

        for(int i=1;i<3;i++){
            for(int j=1;j<3;j++){
                arr[i][j] = arr[i-1][j]+arr[i][j-1];
            }
        }

        System.out.println(arr[2][2]);
    }
}

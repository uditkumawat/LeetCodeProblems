package code.leetcode.studyplan75;

import java.util.Arrays;

//https://leetcode.com/problems/where-will-the-ball-fall/submissions
//TC - O(m*n)
//SC - O(n)
public class WhereWillTheBallFall {

    int k=0;
    public int[] findBall(int[][] arr) {

        int m=arr.length;
        int n=arr[0].length;

        //Initialize []ans with -1
        int []ans=new int[n];
        Arrays.fill(ans, -1);

        //Step-by-Step iterate through first row of [][]arr
        for(int j=0;j<n;j++){
            func(arr,0,j,m,n,ans);
            k++;
        }

        return ans;
    }

    void func(int [][]arr, int i, int j, int m, int n, int []ans){

        // if i has traversed through last row, that means ball has fallen successfully, hence save ans[k]=jth index of arr[i]
        if(i==m){
            ans[k]=j;
            return;
        }

        //if 1 is being traversed and its RIGHT neighbour is wall or RIGHT neighbour is -1
        //ball will get stuck
        if(arr[i][j]==1 && (j+1>=n || arr[i][j+1]==-1))
            return;

            //if -1 is being traversed and its LEFT neighbour is wall or LEFT neighbour is 1
            //ball will get stuck
        else if(arr[i][j]==-1 && (j-1<0 || arr[i][j-1]==1))
            return;

            // if 1 is being traversed so take me to RIGHT diagonal because 1->\
        else if(arr[i][j]==1)
            func(arr,i+1,j+1,m,n,ans);

            // if -1 is being traversed so take me to LEFT diagonal because -1->/
        else if(arr[i][j]==-1)
            func(arr, i+1, j-1,m,n, ans);

    }
}

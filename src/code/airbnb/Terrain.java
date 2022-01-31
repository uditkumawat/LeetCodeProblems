package code.airbnb;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 We are given a one dimensional terrain represented by an array, where the index represents the coordinate and the value represents the altitude.

 A terrain of [5,4,2,1,2,3,2,1,0,1,2,4] will look like

 Write a funtion that prints this terrain:

 +
 ++         +
 ++   +     +
 +++ +++   ++
 ++++++++ +++
 ++++++++++++

 [5]

 +
 +
 +
 +
 +


 */
public class Terrain {

        /**
         space complexity O(kn)
         time complexity
         */
        static void printTerrain(int arr[]) {

            int maxValue = Integer.MIN_VALUE;
            for(int num:arr){
                if(num>maxValue){
                    maxValue = num;
                }
            }

            //matrix
            char board[][] = new char[maxValue+2][arr.length];

            // filling it
            for(int i=0;i<arr.length;i++){

                for(int row=maxValue;row>=maxValue-arr[i];row--){
                    board[row][i] = '+';
                }
            }

            for(int i=0;i<arr.length;i++){
                board[maxValue+1][i] = '+';
            }

            for(int i=0;i<=maxValue;i++){
                for(int j=0;j<arr.length;j++){
                    if(board[i][j]=='+'){
                        System.out.print(board[i][j]);
                    }
                    else{
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }


        }

        public static void main(String[] args) {
            int arr[] = {5,4,2,1,2,3,2,1,0,1,2,4};

            printTerrain(arr);
        }
    }


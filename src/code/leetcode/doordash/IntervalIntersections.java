package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.List;

//TC - O(M+N)
//SC - O(M+N)
public class IntervalIntersections {

    public static void main(String args[]){
        int firstList[][] = {{0,2},{5,10},{13,23},{24,25}};
        int secondList[][] = {{1,5},{8,12},{15,24},{25,26}};

        int finalList[][] = intervalIntersection(firstList,secondList);

        for(int list[]:finalList){
            for(int n:list) {
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> ans = new ArrayList<>();

        int pointer1=0;
        int pointer2=0;

        while(pointer1<firstList.length && pointer2<secondList.length){

            if(firstList[pointer1][1]>secondList[pointer2][0]){
                int startingPoint = Math.max(firstList[pointer1][0],secondList[pointer2][0]);
                int endPoint = Math.min(firstList[pointer1][1],secondList[pointer2][1]);
                if(startingPoint<=endPoint){
                    ans.add(new int[]{startingPoint,endPoint});
                }
            }

            if(firstList[pointer1][1]<secondList[pointer2][1]){
                pointer1++;
            }
            else{
                pointer2++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}

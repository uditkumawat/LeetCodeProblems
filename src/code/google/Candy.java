package code.google;

import java.util.Arrays;

//https://leetcode.com/problems/candy/
//https://www.youtube.com/watch?v=sSwB4ggwzVY
public class Candy {

    public static void main(String args[]){

        int arr[] = {1,2,2};

        Candy obj = new Candy();

        System.out.println(obj.candy(arr));
    }
    public int candy(int[] ratings) {

        int totalCandies = 0;

        if(ratings==null || ratings.length==0){
            return 0;
        }

        int candies[] = new int[ratings.length];

        Arrays.fill(candies,1);

        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                if(candies[i]<candies[i+1]){
                    candies[i] = candies[i+1]+1;
                }
            }
        }

        for(int candy:candies){
            totalCandies = totalCandies+candy;
        }

        return totalCandies;
    }
}

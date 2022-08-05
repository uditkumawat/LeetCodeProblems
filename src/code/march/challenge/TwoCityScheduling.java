package code.march.challenge;

import java.util.Arrays;

//https://www.youtube.com/watch?v=vtNoP43hGJA
public class TwoCityScheduling {

    public static void main(String args[]){

        int costs[][] = {{10,20},{30,200},{400,50},{30,20}};

        TwoCityScheduling obj = new TwoCityScheduling();

        System.out.println(obj.twoCitySchedCost(costs));

    }
    public int twoCitySchedCost(int[][] costs) {

        if(costs==null || costs.length==0){
            return 0;
        }

        int cost = 0;

        //sorting the costs based on ascending order of profit when sending to A rather than B
        Arrays.sort(costs,(cost1, cost2)->{
            return (cost1[1]-cost1[0])-(cost2[1]-cost2[0]);
        });

        for(int i=0;i<costs.length/2;i++){
            cost = cost +  costs[i][1] + costs[costs.length-i-1][0];
            System.out.println(cost);
        }

        return cost;
    }
}

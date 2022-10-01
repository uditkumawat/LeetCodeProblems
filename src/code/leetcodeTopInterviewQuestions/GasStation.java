package code.leetcodeTopInterviewQuestions;

//https://leetcode.com/problems/gas-station/
//https://www.youtube.com/watch?v=ZUL3_p0MJio&t=2s
//TC - O(N)
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalCost = 0;
        int totalGas = 0;
        for(int i=0;i<gas.length;i++){
            totalCost = totalCost+cost[i];
            totalGas = totalGas+gas[i];
        }

        if(totalCost>totalGas){
            return -1;
        }

        int remainingGas = 0;
        int startIndex = 0;

        for(int i=0;i<gas.length;i++){
            remainingGas = remainingGas+(gas[i]-cost[i]);
            if(remainingGas<0){
                startIndex = i+1;
                remainingGas = 0;
            }
        }

        return startIndex;
    }
}

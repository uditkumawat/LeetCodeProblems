package code.leetcodeTopInterviewQuestions;

//https://www.youtube.com/watch?v=OjsmwsdCtX8
//TC - O(N)

public class JumpGame {

    public boolean canJump(int arr[]){

        int reach = 0;

        for(int i=0;i<=reach;i++){
            reach = Math.max(reach,i+arr[i]);
            if(reach>=arr.length-1){
                return true;
            }
        }

        return false;
    }
}

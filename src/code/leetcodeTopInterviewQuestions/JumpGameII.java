package code.leetcodeTopInterviewQuestions;

//https://www.youtube.com/watch?v=wLPdkLM_BWo
//TC - O(N)
public class JumpGameII {

    public int countJumps(int arr[]){

        int farthest = 0;
        int current = 0;
        int jumps = 0;

        for(int i=0;i<arr.length;i++){
            farthest = Math.max(farthest,i+arr[i]);
            if(i==current){
                current = farthest;
                jumps++;
            }
        }

        return jumps;
    }
}

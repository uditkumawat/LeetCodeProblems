package code.top100;

//TC- O(N)
// https://www.youtube.com/watch?v=Zb4eRjuPHbM
public class JumpGame {

    public static void main(String args[]){
        int arr[] = {2,3,1,1,4};

        int lastGoodIndexPosition = args.length-1;

        for(int i=arr.length-1;i>=0;i--){
            if(i+arr[i]>=lastGoodIndexPosition){
                lastGoodIndexPosition = i;
            }
        }

        System.out.print("Jump is possible ");
        System.out.print(lastGoodIndexPosition==0);
    }

    public static boolean canRead(int arr[]){

        int reachable = 0;

        for(int i=0;i<arr.length;i++){
            if(reachable<i){
                return false;
            }
            reachable = Math.max(reachable,i+arr[i]);
        }

        return true;
    }
}

package code.top100;

//https://www.youtube.com/watch?v=03ZepmoVJGI&list=PLEJXowNB4kPxQIN2dCUAnQ_92HIziG4x6&index=40
//TC - O(minimum operations required)
public class MinimumOperations {

    public static void main(String args[]){

        int n =10;

        System.out.println(minSteps(n));
    }

    public static int minSteps(int n){
        int count = 0;
        while(n!=0){
            if(n%2==0){
                n=n/2;
            }
            else{
                n=n-1;
            }
            count++;
        }
        return count;
    }
}

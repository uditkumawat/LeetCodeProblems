package code.explorecard.recursion;

//https://www.youtube.com/watch?v=5P84A0YCo_Y
public class FindKthSymbolInGrammer {

    public int solve(int n,int k){

        if(n==1 && k==1){
            return 0;
        }

        int mid = (int)Math.pow(2,n-1)/2;

        if(k<=mid){
            return solve(n-1,k);
        }
        else{
            return solve(n-1,k-mid)==0?1:0;
        }
    }

}

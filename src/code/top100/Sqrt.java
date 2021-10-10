package code.top100;

public class Sqrt {

    public static void main(String args[]){
        int n=16;
        System.out.println(mySqrt(n));
    }
    public static int mySqrt(int x) {
        if(x<2){
            return x;
        }
        int res=0;
        int mid;
        int left = 1;
        int right = x;
        while(left<=right){
            mid = left+(right-left)/2;
            if(mid==x/mid){
                return mid;
            }
            else if(mid>x/mid){
                right = mid-1;
            }
            else{
                res = mid;
                left = mid+1;
            }
        }

        return res;
    }
}
